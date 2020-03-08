package com.mall.show.shopping.dto;


import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.shopping.constants.ShoppingRetCode;
import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/7/23-18:59
 */
@Data
public class CartListByIdRequest extends AbstractRequest {
    private Long userId;
    @Override
    public void requestCheck() {
        if(userId==null||userId.intValue()==0){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
