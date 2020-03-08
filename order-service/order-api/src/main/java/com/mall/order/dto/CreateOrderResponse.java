package com.mall.order.dto;/**
 */

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/7/30-上午9:49
 */
@Data
public class CreateOrderResponse extends AbstractResponse {

    private String orderId;
}
