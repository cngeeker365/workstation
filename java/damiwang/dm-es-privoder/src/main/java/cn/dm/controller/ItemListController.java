package cn.dm.controller;

import cn.dm.common.Dto;
import cn.dm.common.DtoUtil;
import cn.dm.common.Page;
import cn.dm.es.query.ItemQuery;
import cn.dm.service.ItemSearchService;
import cn.dm.vo.ItemSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taobaibai
 * @create 2020-05-01 17:06
 */
@RestController
@RequestMapping("/api/p/list")
public class ItemListController {

    @Autowired
    private ItemSearchService itemSearchService;

    @RequestMapping("/queryItemList")
    public Dto<Page<ItemSearchVo>> queryItemList(@RequestBody ItemQuery itemQuery) throws Exception {
        Page<ItemSearchVo> result = itemSearchService.queryItemList(itemQuery);
        return DtoUtil.returnDataSuccess(result);
    }
    @RequestMapping("/importItemList")
    public Dto<Page<ItemSearchVo>> importItemList() throws Exception {
        itemSearchService.importItemList();
        return DtoUtil.returnDataSuccess(1);
    }
}
