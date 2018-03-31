package com.littlefisher.blog.biz.cmd.countstatistic;


import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.CountStatistic4BlogDtoConverter;
import com.littlefisher.blog.biz.converter.CountStatisticDtoConverter;
import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.service.ICountStatisticService;
import com.littlefisher.blog.common.enums.EnumCountStatisticState;
import com.littlefisher.blog.common.enums.EnumCountStatisticType;
import com.littlefisher.blog.dal.dao.ICountStatistic4BlogDtoDao;
import com.littlefisher.blog.dal.dao.ICountStatisticDtoDao;
import com.littlefisher.blog.dal.model.CountStatisticDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description: GetBlogCountStatisticCmd.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetBlogCountStatisticCmd extends AbstractCommand<CountStatisticBizExtDto> {

    /** 作者id */
    private Long authorId;

    @Autowired
    private ICountStatisticDtoDao countStatisticDtoDao;

    @Autowired
    private ICountStatistic4BlogDtoDao countStatistic4BlogDtoDao;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetBlogCountStatisticCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public CountStatisticBizExtDto execute() {
        CountStatisticDto countStatistic
            = countStatisticDtoDao.selectOneByRecord(CountStatisticDto.Builder.getInstance().addAuthorId(authorId)
                .addType(EnumCountStatisticType.BLOG).addState(EnumCountStatisticState.VALID).build());
        if (countStatistic == null) {
            // 如果不存在统计记录，则新增博客相关统计记录
            AddBlogCountTimesRequest request = AddBlogCountTimesRequest.Builder.getInstance().addAuthorId(authorId)
                .addAddCommentedTimes(0L).addAddVisitedTimes(0L).build();
            countStatisticService.addBlogCountTimes(request);
            return this.execute();
        }
        return CountStatisticBizExtDto.Builder.getInstance()
            .addCountStatistic(CountStatisticDtoConverter.convert2CountStatisticBizDto(countStatistic))
            .addCountStatistic4Blog(CountStatistic4BlogDtoConverter.convert2CountStatistic4BlogBizDto(
                countStatistic4BlogDtoDao.selectByPrimaryKey(countStatistic.getId())))
            .build();
    }
}
