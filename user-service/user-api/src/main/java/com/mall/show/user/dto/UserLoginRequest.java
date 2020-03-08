package com.mall.show.user.dto;



import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.user.constants.SysRetCodeConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class UserLoginRequest extends AbstractRequest {
    private String userName;
    private String password;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(userName)|| StringUtils.isBlank(password)){
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
