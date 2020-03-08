package com.mall.show.comment.convert;


import com.mall.show.comment.dal.entitys.Comment;
import com.mall.show.comment.dal.entitys.CommentReply;
import com.mall.show.comment.dto.CommentDto;
import com.mall.show.comment.dto.CommentReplyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author heps
 * @date 2019/8/14 23:54
 */
@Mapper(componentModel = "spring")
public interface CommentConverter {

    @Mappings({})
    CommentDto comment2Dto(Comment comment);

    List<CommentDto> comment2Dto(List<Comment> commentList);

    CommentReplyDto commentReply2Dto(CommentReply commentReply);

    List<CommentReplyDto> commentReply2Dto(List<CommentReply> commentReplyList);
}
