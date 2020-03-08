package com.mall.show.comment.utils;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ExceptionUtil;
import com.mall.show.commons.result.AbstractResponse;

/**
 * @author heps
 * @date 2019/8/12 21:22
 */
public class ExceptionProcessorUtil {

    private ExceptionProcessorUtil() {}

    public static void handleException(AbstractResponse response, Exception e) {
        try {
            ExceptionUtil.handlerException4biz(response, e);
        } catch (Exception ex) {
            response.setCode(CommentRetCode.SYSTEM_ERROR.getCode());
            response.setMsg(CommentRetCode.SYSTEM_ERROR.getMessage());
        }
    }
}
