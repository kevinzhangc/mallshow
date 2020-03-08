package com.mall.show.user.dto;

import com.mall.show.commons.result.AbstractRequest;
import lombok.Data;


@Data
public class HeadImageRequest extends AbstractRequest {
    private Long userId;
    private String imageData;

    @Override
    public void requestCheck() {

    }
}
