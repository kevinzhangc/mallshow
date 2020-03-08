package com.mall.show.userprovider.userprovider.services;

import com.alibaba.fastjson.JSON;
import com.mall.show.user.IUserLoginService;
import com.mall.show.user.constants.SysRetCodeConstants;
import com.mall.show.user.dto.CheckAuthRequest;
import com.mall.show.user.dto.CheckAuthResponse;
import com.mall.show.user.dto.UserLoginRequest;
import com.mall.show.user.dto.UserLoginResponse;
import com.mall.show.userprovider.userprovider.converter.UserConverterMapper;
import com.mall.show.userprovider.userprovider.dal.entity.Member;
import com.mall.show.userprovider.userprovider.dal.persistence.MemberMapper;
import com.mall.show.userprovider.userprovider.dal.persistence.UserMapper;
import com.mall.show.userprovider.userprovider.utils.ExceptionProcessorUtils;
import com.mall.show.userprovider.userprovider.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserLoginServiceImpl implements IUserLoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MemberMapper memberMapper;


    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        log.info("Begin UserLoginServiceImpl.login: request:"+request);
        UserLoginResponse response = new UserLoginResponse();
        try{
            request.requestCheck();
            Example example = new Example(Member.class);
            example.createCriteria().andEqualTo("state",1).andEqualTo("username",request.getUserName());
            List<Member> member = memberMapper.selectByExample(example);
            if(member == null || member.size() == 0){
                response.setCode(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            if("N".equals(member.get(0).getIsVerified())){
                response.setCode(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            System.out.println(member.get(0).getPassword());
            System.out.println(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
            System.out.println(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(member.get(0).getPassword()));
            if(!DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(member.get(0).getPassword())){
                response.setCode(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }

            Map<String,Object> map = new HashMap<>();
            map.put("uid",member.get(0).getId());
            map.put("file",member.get(0).getFile());
            String token = JwtTokenUtils.builder().msg(JSON.toJSON(map).toString()).build().creatJwtToken();
            response = UserConverterMapper.INSTANCE.converter(member.get(0));
            response.setToken(token);
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        }catch (Exception e){
            e.printStackTrace();

        }
        return response;
    }

    @Override
    public CheckAuthResponse validToken(CheckAuthRequest request) {
        log.info("Begin UserLoginServiceImpl.validToken: request:"+request);
        CheckAuthResponse response=new CheckAuthResponse();
        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        try{
            request.requestCheck();
            String decodeMsg=JwtTokenUtils.builder().token(request.getToken()).build().freeJwt();
            if(StringUtils.isNotBlank(decodeMsg)){
                log.info("validate success");
                response.setUserinfo(decodeMsg);
                return response;
            }
            response.setCode(SysRetCodeConstants.TOKEN_VALID_FAILED.getCode());
            response.setMsg(SysRetCodeConstants.TOKEN_VALID_FAILED.getMessage());
        }catch (Exception e){
            log.error("UserLoginServiceImpl.validToken Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }
        return response;
    }


    public static void main(String[] args) {
      String str =  DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(str);
    }
}
