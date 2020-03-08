package com.mall.order.dal.persistence;


import com.mall.order.dal.entitys.Order;
import com.mall.show.commons.tkmapper.TkMapper;

public interface OrderMapper extends TkMapper<Order> {
    Long countAll();
}