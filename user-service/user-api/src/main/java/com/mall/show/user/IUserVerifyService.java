package com.mall.show.user;


import com.mall.show.user.dto.UserVerifyRequest;
import com.mall.show.user.dto.UserVerifyResponse;

public interface IUserVerifyService {



    /**
     * 激活邮件
     * @param userVerifyRequest
     * @return
     */
    UserVerifyResponse verifyMemer(UserVerifyRequest userVerifyRequest);
}
