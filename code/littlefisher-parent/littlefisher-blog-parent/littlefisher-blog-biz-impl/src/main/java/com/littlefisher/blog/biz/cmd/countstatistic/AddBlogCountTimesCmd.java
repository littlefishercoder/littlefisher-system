package com.littlefisher.blog.biz.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.common.enums.EnumCountStatisticState;
import com.littlefisher.blog.common.enums.EnumCountStatisticType;
import com.littlefisher.blog.dal.dao.ICountStatistic4BlogDtoDao;
import com.littlefisher.blog.dal.dao.ICountStatisticDtoDao;
import com.littlefisher.blog.dal.model.CountStatistic4BlogDto;
import com.littlefisher.blog.dal.model.CountStatisticDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description: AddBlogCountTimesCmd.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddBlogCountTimesCmd extends AbstractCommand<Void> {

    /** 请求 */
    private AddBlogCountTimesRequest request;

    @Autowired
    private ICountStatisticDtoDao countStatisticDtoDao;

    @Autowired
    private ICountStatistic4BlogDtoDao countStatistic4BlogDtoDao;

    public AddBlogCountTimesCmd setRequest(AddBlogCountTimesRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public Void execute() {
        List<CountStatisticDto> countStatisticList = countStatisticDtoDao
            .selectByRecord(CountStatisticDto.Builder.getInstance().addAuthorId(request.getAuthorId())
                .addState(EnumCountStatisticState.VALID).addType(EnumCountStatisticType.BLOG).build());
        if (CollectionUtil.isEmpty(countStatisticList)) {

            // 新增数据统计总表
            CountStatisticDto countStatisticDto
                = CountStatisticDto.Builder.getInstance().addAuthorId(request.getAuthorId())
                    .addState(EnumCountStatisticState.VALID).addType(EnumCountStatisticType.BLOG)
                    .addCreateDate(DateUtil.getDBDateTime()).addUpdateDate(DateUtil.getDBDateTime()).build();
            countStatisticDtoDao.insert(countStatisticDto);

            // 新增博客数据统计子表
            CountStatistic4BlogDto countStatistic4BlogDto = CountStatistic4BlogDto.Builder.getInstance()
                .addCountStatisticId(countStatisticDto.getId()).addCommentedTimes(request.getAddCommentedTimes())
                .addVisitedTimes(request.getAddVisitedTimes()).build();
            countStatistic4BlogDtoDao.insert(countStatistic4BlogDto);
        } else {
            Long countStatisticId = countStatisticList.get(0).getId();
            CountStatistic4BlogDto countStatistic4BlogDto
                = countStatistic4BlogDtoDao.selectByPrimaryKey(countStatisticId);
            countStatistic4BlogDto
                .setCommentedTimes(countStatistic4BlogDto.getCommentedTimes() + request.getAddCommentedTimes());
            countStatistic4BlogDto
                .setVisitedTimes(countStatistic4BlogDto.getVisitedTimes() + request.getAddVisitedTimes());
            countStatistic4BlogDtoDao.updateByPrimaryKey(countStatistic4BlogDto);
        }
        return null;
    }
}
