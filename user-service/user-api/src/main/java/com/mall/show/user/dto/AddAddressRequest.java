package com.mall.show.user.dto;


import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.user.constants.SysRetCodeConstants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class AddAddressRequest extends AbstractRequest {

    private Long userId;

    private String userName;

    private String tel;

    private String streetName;

    private Integer isDefault;

    @Override
    public void requestCheck() {
        if(userId==null|| StringUtils.isBlank(streetName)|| StringUtils.isBlank(tel)|| StringUtils.isBlank(userName)){
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
