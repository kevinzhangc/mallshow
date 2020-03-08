package com.mall.order.utils;


import com.mall.order.constant.OrderRetCode;
import com.mall.show.commons.exception.ExceptionUtil;
import com.mall.show.commons.result.AbstractResponse;

/**
 *
 *
 *
 * create-date: 2019/7/22-15:48
 */
public class ExceptionProcessorUtils {

    public static void wrapperHandlerException(AbstractResponse response, Exception e){
        try {
            ExceptionUtil.handlerException4biz(response,e);
        } catch (Exception ex) {
            response.setCode(OrderRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(OrderRetCode.SYSTEM_ERROR.getMessage());
        }
    }
}
