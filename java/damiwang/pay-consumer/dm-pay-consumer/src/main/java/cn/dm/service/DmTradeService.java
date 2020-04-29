package cn.dm.service;

import cn.dm.pojo.DmOrder;

/**
 * @author taobaibai
 * @create 2020-04-29 20:20
 */
public interface DmTradeService {
    /**
     * 插入交易记录
     * @param orderNo，tradeNo
     * @return
     * @throws Exception
     */
    public Integer insertTrade(String orderNo, String tradeNo, Integer payMethod) throws Exception;

    /**
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     * @throws Exception
     */
    public DmOrder loadDmOrderByOrderNo(String orderNo) throws Exception;

    /**
     * 判断订单是否支付过
     * @param orderNo
     * @param flag
     * @return
     * @throws Exception
     */
    public boolean processed(String orderNo, Integer flag) throws Exception;
}
