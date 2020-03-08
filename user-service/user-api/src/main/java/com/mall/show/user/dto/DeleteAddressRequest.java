package com.mall.show.user.dto;


import com.mall.show.commons.exception.ValidateException;
import com.mall.show.commons.result.AbstractRequest;
import com.mall.show.user.constants.SysRetCodeConstants;
import lombok.Data;


@Data
public class DeleteAddressRequest extends AbstractRequest {
    private Long addressId;

    @Override
    public void requestCheck() {
        if(addressId==null) {
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
