package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.CountStatistic4BlogBizDto;
import com.littlefisher.blog.dal.model.CountStatistic4BlogDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatistic4BlogDtoConverter.java, v 0.1 2018/3/27 下午7:46 jinyn22648 Exp $$
 */
public final class CountStatistic4BlogDtoConverter {

    /**
     * 私有构造函数
     */
    private CountStatistic4BlogDtoConverter() {}

    /**
     * CountStatistic4BlogBizDto转CountStatistic4BlogDto
     * 
     * @param countStatistic4BlogBizDto CountStatistic4BlogBizDto
     * @return CountStatistic4BlogDto
     */
    public static CountStatistic4BlogDto
        convert2CountStatistic4BlogDto(CountStatistic4BlogBizDto countStatistic4BlogBizDto) {
        return CountStatistic4BlogDto.Builder.getInstance()
            .addCountStatisticId(countStatistic4BlogBizDto.getCountStatisticId())
            .addVisitedTimes(countStatistic4BlogBizDto.getVisitedTimes())
            .addCommentedTimes(countStatistic4BlogBizDto.getCommentedTimes()).build();
    }

    /**
     * CountStatistic4BlogDto转CountStatistic4BlogBizDto
     * 
     * @param countStatistic4BlogDto CountStatistic4BlogDto
     * @return CountStatistic4BlogBizDto
     */
    public static CountStatistic4BlogBizDto
        convert2CountStatistic4BlogBizDto(CountStatistic4BlogDto countStatistic4BlogDto) {
        return CountStatistic4BlogBizDto.Builder.getInstance()
            .addCountStatisticId(countStatistic4BlogDto.getCountStatisticId())
            .addVisitedTimes(countStatistic4BlogDto.getVisitedTimes())
            .addCommentedTimes(countStatistic4BlogDto.getCommentedTimes()).build();
    }
}
