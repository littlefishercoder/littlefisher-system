package com.littlefisher.blog.cmd.countstatistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CountStatistic4PostDtoMapper;
import com.littlefisher.blog.dao.CountStatisticDtoMapper;
import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.enums.EnumCountStatisticState;
import com.littlefisher.blog.enums.EnumCountStatisticType;
import com.littlefisher.blog.example.CountStatistic4PostDtoExample;
import com.littlefisher.blog.model.CountStatistic4PostDto;
import com.littlefisher.blog.model.CountStatisticDto;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.request.AddPostCountTimesRequest;
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
    private PostDtoMapper postDtoMapper;

    @Autowired
    private CountStatisticDtoMapper countStatisticDtoMapper;

    @Autowired
    private CountStatistic4PostDtoMapper countStatistic4PostDtoMapper;

    public AddPostCountTimesCmd setRequest(AddPostCountTimesRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public Void execute() {
        CountStatistic4PostDtoExample countStatistic4PostDtoExample = new CountStatistic4PostDtoExample();
        countStatistic4PostDtoExample.createCriteria().andPostIdEqualTo(request.getPostId());
        List<CountStatistic4PostDto> countStatistic4PostList = countStatistic4PostDtoMapper.selectByExample(countStatistic4PostDtoExample);
        if (CollectionUtil.isEmpty(countStatistic4PostList)) {
            // 如果不存在，则新增
            PostDto postDto = postDtoMapper.selectByPrimaryKey(request.getPostId());
            // 新增数量统计总表
            CountStatisticDto countStatisticDto = new CountStatisticDto();
            countStatisticDto.setAuthorId(postDto.getAuthorId());
            countStatisticDto.setType(EnumCountStatisticType.POST);
            countStatisticDto.setState(EnumCountStatisticState.VALID);
            countStatisticDto.setCreateDate(DateUtil.getDBDateTime());
            countStatisticDto.setUpdateDate(DateUtil.getDBDateTime());
            countStatisticDtoMapper.insert(countStatisticDto);

            // 新增博文数量统计子表
            CountStatistic4PostDto countStatistic4Post = new CountStatistic4PostDto();
            countStatistic4Post.setCountStatisticId(countStatisticDto.getId());
            countStatistic4Post.setPostId(request.getPostId());
            countStatistic4Post.setReadTimes(request.getAddReadTimes());
            countStatistic4Post.setLikedTimes(request.getAddLikedTimes());
            countStatistic4Post.setCommentedTimes(request.getAddCommentedTimes());
            countStatistic4PostDtoMapper.insert(countStatistic4Post);
        } else {
            // 如果存在，则修改
            CountStatistic4PostDto countStatistic4Post = countStatistic4PostList.get(0);
            countStatistic4Post.setCommentedTimes(countStatistic4Post.getCommentedTimes() + request.getAddCommentedTimes());
            countStatistic4Post.setLikedTimes(countStatistic4Post.getLikedTimes() + request.getAddLikedTimes());
            countStatistic4Post.setReadTimes(countStatistic4Post.getReadTimes() + request.getAddReadTimes());
            countStatistic4PostDtoMapper.updateByPrimaryKey(countStatistic4Post);
        }
        return null;
    }
}
