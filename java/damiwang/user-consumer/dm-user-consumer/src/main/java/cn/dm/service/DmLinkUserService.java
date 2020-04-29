package cn.dm.service;

import cn.dm.pojo.DmUser;
import cn.dm.vo.QueryLinkUserVo;

import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-27 17:18
 */
public interface DmLinkUserService {
    /**
     * 根据当前登陆的用户ID获取常用联系人
     * @param userId
     * @return
     * @throws Exception
     */
    public List<QueryLinkUserVo> findLinkUserByUserId(Long userId)throws Exception;
}
