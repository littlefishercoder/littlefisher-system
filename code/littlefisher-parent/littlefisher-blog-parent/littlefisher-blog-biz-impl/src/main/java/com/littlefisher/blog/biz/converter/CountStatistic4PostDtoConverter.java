package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.CountStatistic4PostBizDto;
import com.littlefisher.blog.dal.model.CountStatistic4PostDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatistic4PostDtoConverter.java, v 0.1 2018/3/27 下午8:15 jinyn22648 Exp $$
 */
public class CountStatistic4PostDtoConverter {

    /**
     * CountStatistic4PostBizDto转CountStatistic4PostDto
     * @param countStatistic4PostBizDto CountStatistic4PostBizDto
     * @return CountStatistic4PostDto
     */
    public static CountStatistic4PostDto
        convert2CountStatistic4PostDto(CountStatistic4PostBizDto countStatistic4PostBizDto) {
        return CountStatistic4PostDto.Builder.getInstance().addPostId(countStatistic4PostBizDto.getPostId())
            .addCommentedTimes(countStatistic4PostBizDto.getCommentedTimes())
            .addLikedTimes(countStatistic4PostBizDto.getLikedTimes())
            .addReadTimes(countStatistic4PostBizDto.getReadTimes())
            .addCountStatisticId(countStatistic4PostBizDto.getCountStatisticId()).build();
    }

    /**
     * CountStatistic4PostDto转CountStatistic4PostBizDto
     * @param countStatistic4PostDto CountStatistic4PostDto
     * @return CountStatistic4PostBizDto
     */
    public static CountStatistic4PostBizDto
        convert2CountStatistic4PostBizDto(CountStatistic4PostDto countStatistic4PostDto) {
        return CountStatistic4PostBizDto.Builder.getInstance().addPostId(countStatistic4PostDto.getPostId())
            .addCommentedTimes(countStatistic4PostDto.getCommentedTimes())
            .addLikedTimes(countStatistic4PostDto.getLikedTimes()).addReadTimes(countStatistic4PostDto.getReadTimes())
            .addCountStatisticId(countStatistic4PostDto.getCountStatisticId()).build();
    }

}
