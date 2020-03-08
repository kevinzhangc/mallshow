package com.mall.show.userprovider.userprovider.converter;


import com.mall.show.user.dto.AddAddressRequest;
import com.mall.show.user.dto.AddressDto;
import com.mall.show.user.dto.UpdateAddressRequest;
import com.mall.show.userprovider.userprovider.dal.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AddressConverter {

    @Mappings({})
    AddressDto address2List(Address addresses);

    /*@Mappings({})
    AddressDto address2Res(Address address);*/

    List<AddressDto> address2List(List<Address> addresses);

    @Mappings({})
    Address req2Address(AddAddressRequest request);

    @Mappings({})
    Address req2Address(UpdateAddressRequest request);
}
