package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.dal.model.TagDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: TagDtoConverter.java, v 0.1 2018/3/27 下午8:40 jinyn22648 Exp $$
 */
public class TagDtoConverter {

    /**
     * TagBizDto转TagDto
     * 
     * @param tagBizDto TagBizDto
     * @return TagDto
     */
    public static TagDto convert2TagDto(TagBizDto tagBizDto) {
        return TagDto.Builder.getInstance().addId(tagBizDto.getId()).addName(tagBizDto.getName())
            .addState(tagBizDto.getState()).addStateDate(tagBizDto.getStateDate())
            .addCreateDate(tagBizDto.getCreateDate()).build();
    }

    /**
     * TagDto转TagBizDto
     * 
     * @param tagDto TagDto
     * @return TagBizDto
     */
    public static TagBizDto convert2TagBizDto(TagDto tagDto) {
        return TagBizDto.Builder.getInstance().addId(tagDto.getId()).addName(tagDto.getName())
            .addState(tagDto.getState()).addStateDate(tagDto.getStateDate()).addCreateDate(tagDto.getCreateDate())
            .build();
    }
}
