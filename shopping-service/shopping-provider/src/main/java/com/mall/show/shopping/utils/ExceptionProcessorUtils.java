package com.mall.show.shopping.utils;


import com.mall.show.commons.exception.ExceptionUtil;
import com.mall.show.commons.result.AbstractResponse;
import com.mall.show.shopping.constants.ShoppingRetCode;

public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(ShoppingRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(ShoppingRetCode.SYSTEM_ERROR.getMessage());
        }
    }
}
