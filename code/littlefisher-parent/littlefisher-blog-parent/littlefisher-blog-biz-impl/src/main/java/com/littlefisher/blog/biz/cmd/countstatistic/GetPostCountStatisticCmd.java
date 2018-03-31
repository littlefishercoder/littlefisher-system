package com.littlefisher.blog.biz.cmd.countstatistic;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.CountStatistic4PostDtoConverter;
import com.littlefisher.blog.biz.converter.CountStatisticDtoConverter;
import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;
import com.littlefisher.blog.biz.service.ICountStatisticService;
import com.littlefisher.blog.dal.dao.ICountStatistic4PostDtoDao;
import com.littlefisher.blog.dal.dao.ICountStatisticDtoDao;
import com.littlefisher.blog.dal.model.CountStatistic4PostDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
public class GetPostCountStatisticCmd extends AbstractCommand<CountStatisticBizExtDto> {

    /** 博文id */
    private Long postId;

    @Autowired
    private ICountStatisticDtoDao countStatisticDtoDao;

    @Autowired
    private ICountStatistic4PostDtoDao countStatistic4PostDtoDao;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetPostCountStatisticCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public CountStatisticBizExtDto execute() {
        CountStatistic4PostDto countStatistic4Post = countStatistic4PostDtoDao
            .selectOneByRecord(CountStatistic4PostDto.Builder.getInstance().addPostId(postId).build());
        if (countStatistic4Post == null) {
            AddPostCountTimesRequest request = AddPostCountTimesRequest.Builder.getInstance().addPostId(postId)
                .addAddCommentedTimes(0L).addAddLikedTimes(0L).addAddReadTimes(0L).build();
            countStatisticService.addPostCountTimes(request);
            return this.execute();
        }
        return CountStatisticBizExtDto.Builder.getInstance()
            .addCountStatistic4Post(
                CountStatistic4PostDtoConverter.convert2CountStatistic4PostBizDto(countStatistic4Post))
            .addCountStatistic(CountStatisticDtoConverter.convert2CountStatisticBizDto(
                countStatisticDtoDao.selectByPrimaryKey(countStatistic4Post.getCountStatisticId())))
            .build();
    }
}
