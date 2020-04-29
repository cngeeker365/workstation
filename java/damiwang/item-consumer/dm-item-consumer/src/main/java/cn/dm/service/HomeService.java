package cn.dm.service;

import cn.dm.vo.HotItemVo;

import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-26 12:23
 */
public interface HomeService {
    /**
     * 查询首页轮播图
     * @return
     */
    List<HotItemVo> queryBanner() throws Exception;
}
