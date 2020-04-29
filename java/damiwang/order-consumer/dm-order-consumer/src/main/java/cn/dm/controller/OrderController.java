package cn.dm.controller;

import cn.dm.common.Dto;
import cn.dm.service.OrderService;
import cn.dm.vo.CreateOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taobaibai
 * @create 2020-04-27 22:49
 */
@RestController
@RequestMapping("/api/v")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Dto createOrder(@RequestBody CreateOrderVo orderVo) throws Exception {
        return orderService.createOrder(orderVo);
    }
}
