package com.mall.show.comment.dto;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AuditCommentRequest extends AbstractRequest {

    /**
     * 商品评价id
     */
    private String commentId;

    /**
     * 审核是否通过
     */
    private boolean isValid;

    /**
     * 审核人id
     */
    private Long validationUserId;

    /**
     * 审核意见
     */
    private String validationSuggestion;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentId) || validationUserId == null) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(), CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
        if (!isValid && StringUtils.isEmpty(validationSuggestion)) {
            // 审核不通过时必须填写审核意见
            throw new ValidateException(CommentRetCode.REQUEST_PARAMETER_ERROR.getCode(), CommentRetCode.REQUEST_PARAMETER_ERROR.getMessage());
        }
    }
}
