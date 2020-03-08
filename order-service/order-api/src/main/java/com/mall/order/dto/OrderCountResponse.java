package com.mall.order.dto;/**
 * Created by mic on 2019/7/30.
 */

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/7/30-上午10:00
 */
@Data
public class OrderCountResponse extends AbstractResponse {

    private int count;
}
