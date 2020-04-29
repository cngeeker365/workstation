package cn.dm.service;

import cn.dm.common.Dto;
import cn.dm.vo.CreateOrderVo;

/**
 * @author taobaibai
 * @create 2020-04-27 22:51
 */
public interface OrderService {
    /**
     * 下单
     * @param orderVo
     * @return
     * @throws Exception
     */
    public Dto createOrder(CreateOrderVo orderVo) throws Exception;
}
