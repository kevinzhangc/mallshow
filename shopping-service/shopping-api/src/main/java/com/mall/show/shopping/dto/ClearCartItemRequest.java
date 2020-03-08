package com.mall.show.shopping.dto;/**
 * Created by mic on 2019/8/1.
 */


import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.shopping.constants.ShoppingRetCode;
import lombok.Data;

import java.util.List;

@Data
public class ClearCartItemRequest extends AbstractRequest {

    private Long userId;
    private List<Long> productIds;
    @Override
    public void requestCheck() {
        if(userId==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
