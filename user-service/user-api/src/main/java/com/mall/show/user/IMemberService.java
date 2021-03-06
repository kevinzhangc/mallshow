package com.mall.show.user;/**
 * Created by mic on 2019/7/30.
 */


import com.mall.show.user.dto.*;


public interface IMemberService {

    /**
     * 根据用户id查询用户会员信息
     * @param request
     * @return
     */
    QueryMemberResponse queryMemberById(QueryMemberRequest request);

    /**
     * 修改用户头像
     * @param request
     * @return
     */
    HeadImageResponse updateHeadImage(HeadImageRequest request);

    /**
     * 更新信息
     * @param request
     * @return
     */
    UpdateMemberResponse updateMember(UpdateMemberRequest request);
}
