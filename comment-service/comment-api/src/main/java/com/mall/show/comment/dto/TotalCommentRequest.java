package com.mall.show.comment.dto;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2019/8/17 23:13
 * 查询某个商品的评价总数请求参数
 */
@Data
public class TotalCommentRequest extends AbstractRequest {

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 评价类型 1好评 2中评 3差评
     */
    private Integer type;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(itemId)) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
        if (type != null && (type < 1 || type > 3)) {
            type = null;
        }
    }
}
