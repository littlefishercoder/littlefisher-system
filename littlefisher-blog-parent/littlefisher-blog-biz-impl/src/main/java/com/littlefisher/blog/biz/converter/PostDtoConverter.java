package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.dal.model.PostDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: PostDtoConverter.java, v 0.1 2018/3/27 下午8:28 jinyn22648 Exp $$
 */
public final class PostDtoConverter {

    /**
     * 私有构造函数
     */
    private PostDtoConverter() {}

    /**
     * PostBizDto转PostDto
     * 
     * @param postBizDto PostBizDto
     * @return PostDto
     */
    public static PostDto convert2PostDto(PostBizDto postBizDto) {
        return PostDto.Builder.getInstance().addStateDate(postBizDto.getStateDate()).addState(postBizDto.getState())
            .addType(postBizDto.getType()).addOriginalUrl(postBizDto.getOriginalUrl())
            .addCreatedDate(postBizDto.getCreatedDate()).addEnableComment(postBizDto.getEnableComment())
            .addContent(postBizDto.getContent()).addTitle(postBizDto.getTitle()).addAuthorId(postBizDto.getAuthorId())
            .addArchiveId(postBizDto.getArchiveId()).addId(postBizDto.getId()).addUpdateDate(postBizDto.getUpdateDate())
            .build();
    }

    /**
     * PostDto转PostBizDto
     * 
     * @param postDto PostDto
     * @return PostBizDto
     */
    public static PostBizDto convert2PostBizDto(PostDto postDto) {
        return PostBizDto.Builder.getInstance().addStateDate(postDto.getStateDate()).addState(postDto.getState())
            .addType(postDto.getType()).addOriginalUrl(postDto.getOriginalUrl())
            .addCreatedDate(postDto.getCreatedDate()).addEnableComment(postDto.getEnableComment())
            .addContent(postDto.getContent()).addTitle(postDto.getTitle()).addAuthorId(postDto.getAuthorId())
            .addArchiveId(postDto.getArchiveId()).addId(postDto.getId()).addUpdateDate(postDto.getUpdateDate()).build();
    }

}
