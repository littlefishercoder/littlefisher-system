package com.littlefisher.blog.biz.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;
import com.littlefisher.blog.common.enums.EnumCountStatisticState;
import com.littlefisher.blog.common.enums.EnumCountStatisticType;
import com.littlefisher.blog.dal.dao.ICountStatistic4PostDtoDao;
import com.littlefisher.blog.dal.dao.ICountStatisticDtoDao;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.model.CountStatistic4PostDto;
import com.littlefisher.blog.dal.model.CountStatisticDto;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description: AddPostCountTimesCmd.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddPostCountTimesCmd extends AbstractCommand<Void> {

    /** 请求 */
    private AddPostCountTimesRequest request;

    @Autowired
    private IPostDtoDao postDtoDao;

    @Autowired
    private ICountStatisticDtoDao countStatisticDtoDao;

    @Autowired
    private ICountStatistic4PostDtoDao countStatistic4PostDtoDao;

    public AddPostCountTimesCmd setRequest(AddPostCountTimesRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public Void execute() {
        List<CountStatistic4PostDto> countStatistic4PostList = countStatistic4PostDtoDao
            .selectByRecord(CountStatistic4PostDto.Builder.getInstance().addPostId(request.getPostId()).build());
        if (CollectionUtil.isEmpty(countStatistic4PostList)) {
            // 如果不存在，则新增
            PostDto postDto = postDtoDao.selectByPrimaryKey(request.getPostId());
            // 新增数量统计总表
            CountStatisticDto countStatisticDto
                = CountStatisticDto.Builder.getInstance().addAuthorId(postDto.getAuthorId())
                    .addType(EnumCountStatisticType.POST).addState(EnumCountStatisticState.VALID)
                    .addCreateDate(DateUtil.getDBDateTime()).addUpdateDate(DateUtil.getDBDateTime()).build();
            countStatisticDtoDao.insert(countStatisticDto);

            // 新增博文数量统计子表
            CountStatistic4PostDto countStatistic4Post = CountStatistic4PostDto.Builder.getInstance()
                .addCountStatisticId(countStatisticDto.getId()).addPostId(postDto.getId())
                .addReadTimes(request.getAddReadTimes()).addLikedTimes(request.getAddLikedTimes())
                .addCommentedTimes(request.getAddCommentedTimes()).build();
            countStatistic4PostDtoDao.insert(countStatistic4Post);
        } else {
            // 如果存在，则修改
            CountStatistic4PostDto countStatistic4Post = countStatistic4PostList.get(0);
            countStatistic4Post
                .setCommentedTimes(countStatistic4Post.getCommentedTimes() + request.getAddCommentedTimes());
            countStatistic4Post.setLikedTimes(countStatistic4Post.getLikedTimes() + request.getAddLikedTimes());
            countStatistic4Post.setReadTimes(countStatistic4Post.getReadTimes() + request.getAddReadTimes());
            countStatistic4PostDtoDao.updateByPrimaryKey(countStatistic4Post);
        }
        return null;
    }
}
