package com.mall.show.comment.dto;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2019/8/18 13:24
 * 将商品评价置顶请求参数
 */
@Data
public class TopCommentRequest extends AbstractRequest {

    private String commentId;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentId)) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
