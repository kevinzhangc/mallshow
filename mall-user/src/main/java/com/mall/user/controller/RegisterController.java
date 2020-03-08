package com.mall.user.controller;


import com.mall.show.commons.result.ResponseData;
import com.mall.show.commons.result.ResponseUtil;
import com.mall.show.commons.utils.CookieUtil;
import com.mall.show.user.IKaptchaService;
import com.mall.show.user.IUserRegisterService;
import com.mall.show.user.annotation.Anoymous;
import com.mall.show.user.constants.SysRetCodeConstants;
import com.mall.show.user.dto.KaptchaCodeRequest;
import com.mall.show.user.dto.KaptchaCodeResponse;
import com.mall.show.user.dto.UserRegisterRequest;
import com.mall.show.user.dto.UserRegisterResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class RegisterController {

    @Reference(timeout = 3000)
    IUserRegisterService iUserRegisterService;

    @Reference(timeout = 3000)
    IKaptchaService kaptchaService;
    @Anoymous
    @PostMapping("/register")
    public ResponseData register(@RequestBody Map<String,String> map, HttpServletRequest request){
        String userName=map.get("userName");
        String userPwd=map.get("userPwd");
        String captcha=map.get("captcha");
        String email=map.get("email");
        KaptchaCodeRequest kaptchaCodeRequest = new KaptchaCodeRequest();
        String uuid = CookieUtil.getCookieValue(request, "kaptcha_uuid");
        kaptchaCodeRequest.setUuid(uuid);
        kaptchaCodeRequest.setCode(captcha);
        KaptchaCodeResponse response = kaptchaService.validateKaptchaCode(kaptchaCodeRequest);
        if (!response.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil<>().setErrorMsg(response.getMsg());
        }

        UserRegisterRequest registerRequest=new UserRegisterRequest();
        registerRequest.setUserName(userName);
        registerRequest.setUserPwd(userPwd);
        registerRequest.setEmail(email);
        UserRegisterResponse registerResponse=iUserRegisterService.register(registerRequest);

        if(registerResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil().setData(null);
        }
        return new ResponseUtil().setErrorMsg(registerResponse.getMsg());
    }
}
