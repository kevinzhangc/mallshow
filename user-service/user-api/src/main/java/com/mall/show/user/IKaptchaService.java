package com.mall.show.user;


import com.mall.show.user.dto.KaptchaCodeRequest;
import com.mall.show.user.dto.KaptchaCodeResponse;

public interface IKaptchaService {

    /**
     * 获取图形验证码
     * @param request
     * @return
     */
    KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request);

    /**
     * 验证图形验证码
     * @param request
     * @return
     */
    KaptchaCodeResponse validateKaptchaCode(KaptchaCodeRequest request);

}
