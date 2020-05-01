package cn.dm.service;

import cn.dm.common.Page;
import cn.dm.es.query.ItemQuery;
import cn.dm.vo.ItemSearchVo;

/**
 * @author taobaibai
 * @create 2020-05-01 17:08
 */
public interface ItemSearchService {

    public Page<ItemSearchVo> queryItemList(ItemQuery itemQuery) throws Exception;

    public void importItemList() throws Exception;
}
