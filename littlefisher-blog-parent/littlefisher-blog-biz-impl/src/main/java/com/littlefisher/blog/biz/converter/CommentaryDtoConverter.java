package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.dal.model.CommentaryDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: CommentaryDtoConverter.java, v 0.1 2018/3/27 上午10:16 jinyn22648 Exp $$
 */
public final class CommentaryDtoConverter {

    /**
     * 私有构造函数
     */
    private CommentaryDtoConverter() {}

    /**
     * CommentaryBizDto转CommentaryDto
     * 
     * @param commentaryBizDto CommentaryBizDto
     * @return CommentaryDto
     */
    public static CommentaryDto convert2CommentaryDto(CommentaryBizDto commentaryBizDto) {
        return CommentaryDto.Builder.getInstance().addId(commentaryBizDto.getId())
            .addCommentaryIp(commentaryBizDto.getCommentaryIp()).addContent(commentaryBizDto.getContent())
            .addCreatedDate(commentaryBizDto.getCreatedDate()).addNickName(commentaryBizDto.getNickName())
            .addParentCommentaryId(commentaryBizDto.getParentCommentaryId()).addPostId(commentaryBizDto.getPostId())
            .addState(commentaryBizDto.getState()).addStateDate(commentaryBizDto.getStateDate())
            .addUpdateDate(commentaryBizDto.getUpdateDate()).addUserId(commentaryBizDto.getUserId()).build();
    }

    /**
     * CommentaryDto转CommentaryBizDto
     * 
     * @param commentaryDto CommentaryDto
     * @return CommentaryBizDto
     */
    public static CommentaryBizDto convert2CommentaryBizDto(CommentaryDto commentaryDto) {
        return CommentaryBizDto.Builder.getInstance().addId(commentaryDto.getId())
            .addCommentaryIp(commentaryDto.getCommentaryIp()).addContent(commentaryDto.getContent())
            .addCreatedDate(commentaryDto.getCreatedDate()).addNickName(commentaryDto.getNickName())
            .addParentCommentaryId(commentaryDto.getParentCommentaryId()).addPostId(commentaryDto.getPostId())
            .addState(commentaryDto.getState()).addStateDate(commentaryDto.getStateDate())
            .addUpdateDate(commentaryDto.getUpdateDate()).addUserId(commentaryDto.getUserId()).build();
    }

}
