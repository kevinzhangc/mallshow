package com.mall.show.shopping.dal.persistence;


import com.mall.show.commons.tkmapper.TkMapper;
import com.mall.show.shopping.dal.entitys.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper extends TkMapper<Item> {

    List<Item> selectItemFront(@Param("cid") Long cid,
                               @Param("orderCol") String orderCol, @Param("orderDir") String orderDir,
                               @Param("priceGt") Integer priceGt, @Param("priceLte") Integer priceLte);
}