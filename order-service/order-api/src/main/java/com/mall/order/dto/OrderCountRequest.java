package com.mall.order.dto;/**
 */


import com.mall.order.constant.OrderRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/7/30-上午9:59
 */
@Data
public class OrderCountRequest extends AbstractRequest {

    private Long userId;

    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
