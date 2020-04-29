package cn.dm.service.impl;

import cn.dm.client.RestDmLinkUserClient;
import cn.dm.pojo.DmLinkUser;
import cn.dm.service.DmLinkUserService;
import cn.dm.vo.QueryLinkUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-27 21:25
 */
@Component
public class DmLinkUserServiceImpl implements DmLinkUserService {

    @Autowired
    private RestDmLinkUserClient dmLinkUserClient;

    @Override
    public List<QueryLinkUserVo> findLinkUserByUserId(Long userId) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        List<DmLinkUser> dmLinkUsers = dmLinkUserClient.getDmLinkUserListByMap(params);
        List<QueryLinkUserVo> queryLinkUserVos = new ArrayList<>();
        if (dmLinkUsers.size() > 0) {
            //组装数据
            for (DmLinkUser dmLinkUser : dmLinkUsers) {
                QueryLinkUserVo queryLinkUserVo = new QueryLinkUserVo();
                BeanUtils.copyProperties(dmLinkUser, queryLinkUserVo);
                queryLinkUserVos.add(queryLinkUserVo);
            }
            return queryLinkUserVos;
        }
        return null;
    }
}
