package com.mall.show.shopping.dto;

import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;

/**
 * Created by mic on 2019/7/23.
 */
@Data
public class AddCartRequest extends AbstractRequest {

    private Long userId;
    private Long itemId;
    private Integer num;

    @Override
    public void requestCheck() {

    }
}
