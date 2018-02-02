package com.littlefisher.blog.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CountStatistic4PostDtoMapper;
import com.littlefisher.blog.dao.CountStatisticDtoMapper;
import com.littlefisher.blog.example.CountStatistic4PostDtoExample;
import com.littlefisher.blog.model.CountStatistic4PostDto;
import com.littlefisher.blog.model.ext.CountStatisticExtDto;
import com.littlefisher.blog.request.AddPostCountTimesRequest;
import com.littlefisher.blog.service.ICountStatisticService;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;

/**
 * Description: GetPostCountStatisticCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetPostCountStatisticCmd extends AbstractCommand<CountStatisticExtDto> {

    /** 博文id */
    private Long postId;

    @Autowired
    private CountStatisticDtoMapper countStatisticDtoMapper;

    @Autowired
    private CountStatistic4PostDtoMapper countStatistic4PostDtoMapper;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetPostCountStatisticCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public CountStatisticExtDto execute() {
        CountStatistic4PostDtoExample countStatistic4PostDtoExample = new CountStatistic4PostDtoExample();
        countStatistic4PostDtoExample.createCriteria()
                .andPostIdEqualTo(postId);
        List<CountStatistic4PostDto> countStatistic4PostList = countStatistic4PostDtoMapper.selectByExample(
                countStatistic4PostDtoExample);
        if (CollectionUtil.isEmpty(countStatistic4PostList)) {
            AddPostCountTimesRequest request = new AddPostCountTimesRequest();
            request.setPostId(postId);
            request.setAddCommentedTimes(0L);
            request.setAddLikedTimes(0L);
            request.setAddReadTimes(0L);
            countStatisticService.addPostCountTimes(request);
            return this.execute();
        }
        CountStatistic4PostDto countStatistic4PostDto = countStatistic4PostList.get(0);
        CountStatisticExtDto countStatisticExtDto = new CountStatisticExtDto();
        BeanUtils.copyProperties(countStatisticExtDto,
                countStatisticDtoMapper.selectByPrimaryKey(countStatistic4PostDto.getCountStatisticId()));
        countStatisticExtDto.setCountStatistic4Post(countStatistic4PostDto);
        return countStatisticExtDto;
    }
}
