package com.mall.show.userprovider.userprovider.converter;


import com.mall.show.user.dto.UserLoginResponse;
import com.mall.show.userprovider.userprovider.dal.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserConverterMapper {

    UserConverterMapper INSTANCE= Mappers.getMapper(UserConverterMapper.class);

    @Mappings({})
    UserLoginResponse converter(Member member);

}
