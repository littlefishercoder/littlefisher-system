package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.dal.model.PostTagDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: PostTagDtoConverter.java, v 0.1 2018/3/27 下午8:47 jinyn22648 Exp $$
 */
public class PostTagDtoConverter {

    /**
     * PostTagBizDto转PostTagDto
     * @param postTagBizDto PostTagBizDto
     * @return PostTagDto
     */
    public static PostTagDto convert2PostTagDto(PostTagBizDto postTagBizDto) {
        return PostTagDto.Builder.getInstance().addId(postTagBizDto.getId()).addState(postTagBizDto.getState())
            .addTagId(postTagBizDto.getTagId()).addPostId(postTagBizDto.getPostId())
            .addCreateDate(postTagBizDto.getCreateDate()).addUpdateDate(postTagBizDto.getUpdateDate()).build();

    }

    /**
     * PostTagDto转PostTagBizDto
     * @param postTagDto PostTagDto
     * @return PostTagBizDto
     */
    public static PostTagBizDto convert2PostTagBizDto(PostTagDto postTagDto) {
        return PostTagBizDto.Builder.getInstance().addId(postTagDto.getId()).addState(postTagDto.getState())
            .addTagId(postTagDto.getTagId()).addPostId(postTagDto.getPostId()).addCreateDate(postTagDto.getCreateDate())
            .addUpdateDate(postTagDto.getUpdateDate()).build();
    }

}
