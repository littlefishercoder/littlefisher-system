package com.littlefisher.blog.biz.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.blog.biz.cmd.countstatistic.AddBlogCountTimesCmd;
import com.littlefisher.blog.biz.cmd.countstatistic.AddPostCountTimesCmd;
import com.littlefisher.blog.biz.cmd.countstatistic.GetBlogCountStatisticCmd;
import com.littlefisher.blog.biz.cmd.countstatistic.GetPostCountStatisticCmd;
import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;
import com.littlefisher.blog.biz.service.ICountStatisticService;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
 * Description: CountStatisticServiceImpl.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Service(interfaceClass = ICountStatisticService.class)
public class CountStatisticServiceImpl extends ServiceImpl implements ICountStatisticService {

    @Override
    public CountStatisticBizExtDto getBlogCountStatistic(Long authorId) {
        return execute(getCommand(GetBlogCountStatisticCmd.class).setAuthorId(authorId));
    }

    @Override
    public CountStatisticBizExtDto getPostCountStatistic(Long postId) {
        return execute(getCommand(GetPostCountStatisticCmd.class).setPostId(postId));
    }

    @Override
    public void addBlogCountTimes(AddBlogCountTimesRequest request) {
        execute(getCommand(AddBlogCountTimesCmd.class).setRequest(request));
    }

    @Override
    public void addPostCountTimes(AddPostCountTimesRequest request) {
        execute(getCommand(AddPostCountTimesCmd.class).setRequest(request));
    }
}
