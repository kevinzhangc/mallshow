package com.mall.show.comment.dto;


import com.mall.show.comment.constant.CommentRetCode;
import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @date 2019/8/22 23:32
 * 商品评价回复意见分页查询请求参数
 */
@Data
public class CommentReplyListRequest extends AbstractRequest {

    /**
     * 商品评价id或者回复意见id
     */
    private String commentId;

    private int page;

    private int size;

    @Override
    public void requestCheck() {
        if (StringUtils.isEmpty(commentId)) {
            throw new ValidateException(CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),CommentRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
        if (page < 1) {
            setPage(1);
        }
        if (size < 1) {
            size = 10;
        }
    }
}
