package com.littlefisher.blog.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CountStatistic4BlogDtoMapper;
import com.littlefisher.blog.dao.CountStatisticDtoMapper;
import com.littlefisher.blog.enums.EnumCountStatisticState;
import com.littlefisher.blog.enums.EnumCountStatisticType;
import com.littlefisher.blog.example.CountStatisticDtoExample;
import com.littlefisher.blog.model.CountStatistic4BlogDto;
import com.littlefisher.blog.model.CountStatisticDto;
import com.littlefisher.blog.request.AddBlogCountTimesRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
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
    private CountStatisticDtoMapper countStatisticDtoMapper;

    @Autowired
    private CountStatistic4BlogDtoMapper countStatistic4BlogDtoMapper;

    public AddBlogCountTimesCmd setRequest(AddBlogCountTimesRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public Void execute() {
        CountStatisticDtoExample countStatisticDtoExample = new CountStatisticDtoExample();
        countStatisticDtoExample.createCriteria().andAuthorIdEqualTo(request.getAuthorId()).andStateEqualTo(
                EnumCountStatisticState.VALID).andTypeEqualTo(EnumCountStatisticType.BLOG);
        List<CountStatisticDto> countStatisticList = countStatisticDtoMapper.selectByExample(countStatisticDtoExample);
        if (CollectionUtil.isEmpty(countStatisticList)) {

            // 新增数据统计总表
            CountStatisticDto countStatisticDto = new CountStatisticDto();
            countStatisticDto.setAuthorId(request.getAuthorId());
            countStatisticDto.setState(EnumCountStatisticState.VALID);
            countStatisticDto.setType(EnumCountStatisticType.BLOG);
            countStatisticDto.setCreateDate(DateUtil.getDBDateTime());
            countStatisticDto.setUpdateDate(DateUtil.getDBDateTime());
            countStatisticDtoMapper.insert(countStatisticDto);

            // 新增博客数据统计子表
            CountStatistic4BlogDto countStatistic4BlogDto = new CountStatistic4BlogDto();
            countStatistic4BlogDto.setCountStatisticId(countStatisticDto.getId());
            countStatistic4BlogDto.setVisitedTimes(request.getAddVisitedTimes());
            countStatistic4BlogDto.setCommentedTimes(request.getAddCommentedTimes());
            countStatistic4BlogDtoMapper.insert(countStatistic4BlogDto);
        } else {
            Long countStatisticId = countStatisticList.get(0).getId();
            CountStatistic4BlogDto countStatistic4BlogDto = countStatistic4BlogDtoMapper.selectByPrimaryKey(countStatisticId);
            countStatistic4BlogDto.setCommentedTimes(countStatistic4BlogDto.getCommentedTimes() + request.getAddCommentedTimes());
            countStatistic4BlogDto.setVisitedTimes(countStatistic4BlogDto.getVisitedTimes() + request.getAddVisitedTimes());
            countStatistic4BlogDtoMapper.updateByPrimaryKey(countStatistic4BlogDto);
        }
        return null;
    }
}
