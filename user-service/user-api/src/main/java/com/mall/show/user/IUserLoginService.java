package com.mall.show.user;

import com.mall.show.user.dto.CheckAuthRequest;
import com.mall.show.user.dto.CheckAuthResponse;
import com.mall.show.user.dto.UserLoginRequest;
import com.mall.show.user.dto.UserLoginResponse;

public interface IUserLoginService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);


    /**
     * 校验过程
     * @param request
     * @return
     */
    CheckAuthResponse validToken(CheckAuthRequest request);
}
