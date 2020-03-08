package com.mall.show.comment.dto;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddCommentReplyRequest extends AbstractRequest {

    /**
     * 商品评价id或者回复意见id
     */
    private String commentId;

    /**
     * 回复用户id
     */
    private Long userId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复人昵称
     */
    private String replyNick;
    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentId) || StringUtils.isEmpty(content) || null == userId) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
