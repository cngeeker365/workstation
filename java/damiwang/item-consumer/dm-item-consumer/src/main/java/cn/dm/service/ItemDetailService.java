package cn.dm.service;

import cn.dm.common.Dto;
import cn.dm.vo.ItemDetailVo;
import cn.dm.vo.ItemPriceVo;
import cn.dm.vo.ItemSchedulerVo;

import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-27 13:36
 */
public interface ItemDetailService {

    Dto<ItemDetailVo> queryItemDetail(Long id) throws Exception;

    Dto<List<ItemSchedulerVo>> queryItemScheduler(Long id) throws Exception;

    Dto<List<ItemPriceVo>> queryItemPrice(Long id) throws Exception;
}
