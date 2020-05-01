package cn.dm.item;

import cn.dm.es.query.AbstractEsQuery;
import cn.dm.vo.ItemSearchVo;

/**
 * @author taobaibai
 * @create 2020-05-01 17:12
 */
public class ItemEsQuery extends AbstractEsQuery {
    @Override
    public String getIndexName() {
        return "dm";
    }

    @Override
    public String getTypeName() {
        return "item";
    }

    @Override
    public Class getModuleClass() {
        return ItemSearchVo.class;
    }
}
