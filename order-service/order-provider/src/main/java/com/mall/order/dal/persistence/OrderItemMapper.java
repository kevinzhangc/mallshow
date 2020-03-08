package com.mall.order.dal.persistence;


import com.mall.order.dal.entitys.OrderItem;
import com.mall.show.commons.tkmapper.TkMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper extends TkMapper<OrderItem> {
    List<OrderItem> queryByOrderId(@Param("orderId") String orderId);
    void updateStockStatus(@Param("status") Integer status,@Param("orderId") String orderId);
}