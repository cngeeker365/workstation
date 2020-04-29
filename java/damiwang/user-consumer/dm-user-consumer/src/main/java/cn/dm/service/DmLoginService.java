package cn.dm.service;

import cn.dm.pojo.DmUser;
import cn.dm.vo.DmUserVO;

import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-27 17:18
 */
public interface DmLoginService {
    /**
     * 账号密码登陆
     *
     * @param dmUser
     * @return
     * @throws Exception
     */
    public Object[] login(DmUser dmUser) throws Exception;

    /**
     * 根据token获取当前登陆的用户信息
     *
     * @param tokenString
     * @return
     * @throws Exception
     */
    public DmUserVO loadCurrentUserByTokenAsDmUserVo(String tokenString) throws Exception;

    /**
     * 获取微信用户信息，进行自身业务实现
     * @param userInfoMap
     * @throws Exception
     */
    public String wechatLogin(Map<String, Object> userInfoMap, String openId) throws Exception;
}
