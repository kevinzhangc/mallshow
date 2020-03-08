
package com.mall.order.biz.convert;



import com.mall.order.biz.context.TransHandlerContext;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.commons.result.AbstractResponse;

/**
 *
 *
 *
 * create-date: 2019/8/2-下午9:55
 */
public interface TransConvert {
    /**
     * 请求转上下文
     * 
     * @param req
     * @return
     */
    TransHandlerContext convertRequest2Ctx(AbstractRequest req, TransHandlerContext context);
    
    /**
     * 上下文转应答
     * 
     * @param ctx
     * @return
     */
    AbstractResponse convertCtx2Respond(TransHandlerContext ctx);
}
