package cn.dm.service.impl;

import cn.dm.client.RestDmImageClient;
import cn.dm.client.RestDmUserClient;
import cn.dm.common.Constants;
import cn.dm.common.EmptyUtils;
import cn.dm.common.RedisUtils;
import cn.dm.pojo.DmImage;
import cn.dm.pojo.DmUser;
import cn.dm.service.DmLoginService;
import cn.dm.vo.DmUserVO;
import cn.dm.vo.TokenVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-27 17:20
 */
@Component
public class DmLoginServiceImpl implements DmLoginService {
    @Autowired
    private RestDmUserClient userClient;
    @Autowired
    private RestDmImageClient imageClient;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Object[] login(DmUser user) throws Exception {
        //验证用户登录是否成功
        DmUser dmUser = userClient.checkLoginByPassword(user);
        if (EmptyUtils.isEmpty(dmUser)) {
            return null;
        }
        //组装信息
        DmUserVO dmUserVO = new DmUserVO();
        BeanUtils.copyProperties(dmUser, dmUserVO);
        dmUserVO.setUserId(dmUser.getId());

        //更新用户头像
        List<DmImage> dmImageList = imageClient.queryDmImageList(dmUser.getId(), Constants.Image.ImageType.carousel, Constants.Image.ImageCategory.item);
        if (EmptyUtils.isNotEmpty(dmImageList)) {
            dmUserVO.setImageId(dmImageList.get(0).getId());
            dmUserVO.setImgUrl(dmImageList.get(0).getImgUrl());
        }

        //生产用户 Token
        String token = generateToken(dmUser);
        //保存token到redis中
        this.saveToken(token, dmUserVO);

        TokenVO tokenVO = new TokenVO(token, Constants.Redis_Expire.SESSION_TIMEOUT, System.currentTimeMillis());
        return new Object[]{dmUserVO, tokenVO};
    }

    private String generateToken(DmUser dmUser) {
        return userClient.generateToken(dmUser);
    }

    private void saveToken(String token, DmUserVO dmUserVO) {
        String tokenKey = Constants.USER_TOKEN_PREFIX + dmUserVO.getUserId();
        String tokenValue = null;
        //检查是否已经登陆，如果还在登陆有效期内，就需要删除掉原来的登陆信息
        if ((tokenValue = (String) redisUtils.get(tokenKey)) != null) {
            //代表原来用户已经登陆
            redisUtils.delete(tokenKey);
        }
        //缓存用户token
        redisUtils.set(tokenKey, Constants.Redis_Expire.SESSION_TIMEOUT, token);
        //缓存用户详细信息
        redisUtils.set(token, Constants.Redis_Expire.SESSION_TIMEOUT, JSON.toJSONString(dmUserVO));
    }

    @Override
    public DmUserVO loadCurrentUserByTokenAsDmUserVo(String tokenString) throws Exception {
        String tokenUser = null;
        if((tokenUser = (String)redisUtils.get(tokenString)) == null ){
            //抛出异常
            return null;
        }

        return JSONObject.parseObject(tokenUser, DmUserVO.class);
    }

    @Override
    public String wechatLogin(Map<String, Object> userInfoMap, String openId) throws Exception {
        //获取微信用户信息入库——用户昵称
        String nickName = userInfoMap.get("nickname").toString();
        //获取微信用户信息入库——用户性别
        String sex = userInfoMap.get("sex").toString();
        //获取微信用户信息入库——用户头像
        String headimgurl = userInfoMap.get("headimgurl").toString();

        //判断是否已经入库
        DmUser dmUser = userClient.getDmUserByWxUserId(openId);
        //dmUser为null，则进行入库操作
        Long userId = 0L;
        if(EmptyUtils.isEmpty(dmUser)){
            dmUser = new DmUser();
            dmUser.setNickName(nickName);
            dmUser.setSex(Integer.parseInt(sex));
            dmUser.setWxUserId(openId);
            userId = this.userClient.createWxUser(dmUser).longValue();
        }
        DmUserVO dmUserVO = new DmUserVO();
        BeanUtils.copyProperties(dmUser, dmUserVO);
        //获取用户的头像
        // 1.从redis里面获取的
        String key = Constants.IMAGE_TOKEN_PREFIX + userId.toString() + "_" +Constants.Image.ImageType.normal + "_" + Constants.Image.ImageCategory.user;
        String imgUrl = (String)redisUtils.get(key);
        if(EmptyUtils.isEmpty(imgUrl)){
            List<DmImage> dmImages = imageClient.queryDmImageList(userId, Constants.Image.ImageType.normal, Constants.Image.ImageCategory.user);
            if(EmptyUtils.isNotEmpty(dmImages)){
                String imgUrlStr = dmImages.get(0).getImgUrl();
                if(Constants.DEFAULT_USER.equals(imgUrlStr)){
                    //将用户头像缓存到redis中
                    redisUtils.set(key, headimgurl);
                    dmUserVO.setImgUrl(headimgurl);
                    //将用户的头像入库
                    DmImage dmImage = new DmImage();
                    dmImage.setTargetId(Integer.parseInt(userId.toString()));
                    dmImage.setCategory(Constants.Image.ImageCategory.user);
                    dmImage.setType(Constants.Image.ImageType.normal);
                    imageClient.qdtxAddDmImage(dmImage);
                }else{
                    dmUserVO.setImgUrl(imgUrlStr);
                    redisUtils.set(key, imgUrlStr);
                }
            }
        }else{
            dmUserVO.setImgUrl(imgUrl);
        }
        dmUserVO.setUserId(userId);
        //生成token
        String token = this.generateToken(dmUser);
        //缓存用户信息到redis中
        this.saveToken(token, dmUserVO);
        return token;
    }
}
