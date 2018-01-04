package com.littlefisher.blog.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CountStatistic4BlogDtoMapper;
import com.littlefisher.blog.dao.CountStatisticDtoMapper;
import com.littlefisher.blog.enums.EnumCountStatisticState;
import com.littlefisher.blog.enums.EnumCountStatisticType;
import com.littlefisher.blog.example.CountStatisticDtoExample;
import com.littlefisher.blog.model.CountStatisticDto;
import com.littlefisher.blog.model.ext.CountStatisticExtDto;
import com.littlefisher.blog.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.service.ICountStatisticService;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.CollectionUtil;

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
public class GetBlogCountStatisticCmd extends AbstractCommand<CountStatisticExtDto> {

    /** 作者id */
    private Long authorId;

    @Autowired
    private CountStatisticDtoMapper countStatisticDtoMapper;

    @Autowired
    private CountStatistic4BlogDtoMapper countStatistic4BlogDtoMapper;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetBlogCountStatisticCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public CountStatisticExtDto execute() {
        CountStatisticDtoExample countStatisticDtoExample = new CountStatisticDtoExample();
        countStatisticDtoExample.createCriteria().andAuthorIdEqualTo(authorId).andTypeEqualTo(
                EnumCountStatisticType.BLOG).andStateEqualTo(EnumCountStatisticState.VALID);
        List<CountStatisticDto> countStatisticList = countStatisticDtoMapper.selectByExample(countStatisticDtoExample);
        if (CollectionUtil.isEmpty(countStatisticList)) {
            // 如果不存在统计记录，则新增博客相关统计记录
            AddBlogCountTimesRequest request = new AddBlogCountTimesRequest();
            request.setAuthorId(request.getAuthorId());
            request.setAddCommentedTimes(0L);
            request.setAddVisitedTimes(0L);
            countStatisticService.addBlogCountTimes(request);
            return this.execute();
        }
        CountStatisticExtDto countStatistic = (CountStatisticExtDto) countStatisticList.get(0);
        countStatistic.setCountStatistic4Blog(countStatistic4BlogDtoMapper.selectByPrimaryKey(countStatistic.getId()));
        return countStatistic;
    }
}
