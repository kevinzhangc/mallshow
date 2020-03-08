package com.mall.show.shopping.dto;


import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.shopping.constants.ShoppingRetCode;
import lombok.Data;


@Data
public class ProductDetailRequest extends AbstractRequest {

    private Long id;

    @Override
    public void requestCheck() {
        if(id==null){
            throw new ValidateException(ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),ShoppingRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
