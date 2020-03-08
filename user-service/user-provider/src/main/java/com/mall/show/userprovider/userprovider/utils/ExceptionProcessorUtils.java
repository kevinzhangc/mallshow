package com.mall.show.userprovider.userprovider.utils;


import com.mall.show.commons.exception.ExceptionUtil;
import com.mall.show.commons.result.AbstractResponse;
import com.mall.show.user.constants.SysRetCodeConstants;

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
            response.setCode(SysRetCodeConstants.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeConstants.SYSTEM_ERROR.getMessage());
        }
    }
}
