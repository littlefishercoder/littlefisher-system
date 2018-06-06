package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.CountStatisticBizDto;
import com.littlefisher.blog.dal.model.CountStatisticDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatisticDtoConverter.java, v 0.1 2018/3/27 下午7:32 jinyn22648 Exp $$
 */
public final class CountStatisticDtoConverter {

    /**
     * 私有构造函数
     */
    private CountStatisticDtoConverter() {}

    /**
     * CountStatisticBizDto转CountStatisticDto
     * 
     * @param countStatisticBizDto CountStatisticBizDto
     * @return CountStatisticDto
     */
    public static CountStatisticDto convert2CountStatisticDto(CountStatisticBizDto countStatisticBizDto) {
        return CountStatisticDto.Builder.getInstance().addId(countStatisticBizDto.getId())
            .addAuthorId(countStatisticBizDto.getAuthorId()).addState(countStatisticBizDto.getState())
            .addType(countStatisticBizDto.getType()).addCreateDate(countStatisticBizDto.getCreateDate())
            .addUpdateDate(countStatisticBizDto.getUpdateDate()).build();
    }

    /**
     * CountStatisticDto转CountStatisticBizDto
     * 
     * @param countStatisticDto CountStatisticDto
     * @return CountStatisticBizDto
     */
    public static CountStatisticBizDto convert2CountStatisticBizDto(CountStatisticDto countStatisticDto) {
        return CountStatisticBizDto.Builder.getInstance().addId(countStatisticDto.getId())
            .addAuthorId(countStatisticDto.getAuthorId()).addState(countStatisticDto.getState())
            .addType(countStatisticDto.getType()).addCreateDate(countStatisticDto.getCreateDate())
            .addUpdateDate(countStatisticDto.getUpdateDate()).build();
    }
}
