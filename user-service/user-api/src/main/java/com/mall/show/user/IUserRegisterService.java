package com.mall.show.user;


import com.mall.show.user.dto.UserRegisterRequest;
import com.mall.show.user.dto.UserRegisterResponse;

public interface IUserRegisterService {

    /**
     * 实现用户注册功能
     * @param request
     * @return
     */
    UserRegisterResponse register(UserRegisterRequest request);
}
