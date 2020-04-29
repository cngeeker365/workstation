package cn.dm.service;

import cn.dm.common.IdWorker;
import cn.dm.vo.DmItemMessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dm.mapper.DmTradeMapper;
import cn.dm.pojo.DmTrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * Created by dm
 */
@RestController
public class RestDmTradeService {
    private static final Logger logger = LoggerFactory.getLogger(RestDmTradeService.class);

    @Resource
    private RabbitTemplate rabbitTemplate;
     @Autowired
     private DmTradeMapper dmTradeMapper;

     @RequestMapping(value = "/getDmTradeById",method = RequestMethod.POST)
     public DmTrade getDmTradeById(@RequestParam("id") Long id)throws Exception{
        return dmTradeMapper.getDmTradeById(id);
     }

     @RequestMapping(value = "/getDmTradeListByMap",method = RequestMethod.POST)
     public List<DmTrade>	getDmTradeListByMap(@RequestParam Map<String,Object> param)throws Exception{
        return dmTradeMapper.getDmTradeListByMap(param);
     }

     @RequestMapping(value = "/getDmTradeCountByMap",method = RequestMethod.POST)
     public Integer getDmTradeCountByMap(@RequestParam Map<String,Object> param)throws Exception{
        return dmTradeMapper.getDmTradeCountByMap(param);
     }

     @RequestMapping(value = "/qdtxAddDmTrade",method = RequestMethod.POST)
     public Integer qdtxAddDmTrade(@RequestBody DmTrade dmTrade)throws Exception{
        dmTrade.setCreatedTime(new Date());
        return dmTradeMapper.insertDmTrade(dmTrade);
     }

     @RequestMapping(value = "/qdtxModifyDmTrade",method = RequestMethod.POST)
     public Integer qdtxModifyDmTrade(@RequestBody DmTrade dmTrade)throws Exception{
        dmTrade.setUpdatedTime(new Date());
        return dmTradeMapper.updateDmTrade(dmTrade);
     }

    @RequestMapping(value = "/insertTrade",method = RequestMethod.POST)
    public Integer insertTrade(@RequestBody DmItemMessageVo dmItemMessageVo) throws Exception {
        DmTrade qgTrade = new DmTrade();
        qgTrade.setId(IdWorker.getId().toString());
        qgTrade.setAmount(dmItemMessageVo.getAmount());
        qgTrade.setCreatedTime(Calendar.getInstance().getTime());
        qgTrade.setOrderNo(dmItemMessageVo.getOrderNo());
        qgTrade.setPayMethod(1);
        qgTrade.setTradeNo(dmItemMessageVo.getTradeNo());
        return dmTradeMapper.insertDmTrade(qgTrade);
    }
}
