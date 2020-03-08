package com.mall.show.comment.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

/**
 *
 * @date 2019/8/17 23:16
 */
@Data
public class TotalCommentResponse extends AbstractResponse {

    private long total;
}
