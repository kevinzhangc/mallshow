package com.mall.show.user.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;


@Data
public class AddressDetailResponse extends AbstractResponse {
	private AddressDto addressDto;
    
}
