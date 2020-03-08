package com.mall.order.biz.handler;/**
 * Created by mic on 2019/8/2.
 */

import lombok.Data;

/**
 *
 *
 *
 * create-date: 2019/8/2-下午10:01
 */
@Data
public abstract class AbstractTransHandler implements com.mall.order.biz.handler.TransHandler {

    public static final String DEFAULT = "default";

    public com.mall.order.biz.callback.TransCallback getTransCallback(){return null;}
}
