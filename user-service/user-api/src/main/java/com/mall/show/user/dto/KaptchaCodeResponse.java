package com.mall.show.user.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

@Data
public class KaptchaCodeResponse extends AbstractResponse {

    private String imageCode;

    private String uuid;


}
