package com.mall.order.dto;/**
 * Created by mic on 2019/7/30.
 */


import com.mall.order.constant.OrderRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/7/30-上午10:02
 */
@Data
public class OrderListRequest extends AbstractRequest {

    private Long userId;
    private Integer page;
    private Integer size;
    private String sort;

    @Override
    public void requestCheck() {
        if(page == null || page < 1){
            page = 1;
        }
        if(size == null || size < 1){
            size = 5;
        }
        if(userId==null){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());

        }
    }
}