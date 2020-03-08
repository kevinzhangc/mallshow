package com.mall.show.userprovider.userprovider.converter;


import com.mall.show.user.dto.QueryMemberResponse;
import com.mall.show.user.dto.UpdateMemberRequest;
import com.mall.show.userprovider.userprovider.dal.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface MemberConverter {

    @Mappings({})
    QueryMemberResponse member2Res(Member member);

    @Mappings({})
    Member updateReq2Member(UpdateMemberRequest request);
}
