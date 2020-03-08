package com.mall.show.user.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;


@Data
public class AddressListResponse extends AbstractResponse {

    private List<AddressDto> addressDtos;
}
