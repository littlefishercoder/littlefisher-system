package com.littlefisher.blog.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.countstatistic.AddBlogCountTimesCmd;
import com.littlefisher.blog.cmd.countstatistic.AddPostCountTimesCmd;
import com.littlefisher.blog.cmd.countstatistic.GetBlogCountStatisticCmd;
import com.littlefisher.blog.model.ext.CountStatisticExtDto;
import com.littlefisher.blog.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.request.AddPostCountTimesRequest;
import com.littlefisher.blog.service.ICountStatisticService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: CountStatisticServiceImpl.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class CountStatisticServiceImpl extends ServiceImpl implements ICountStatisticService {

    @Override
    public CountStatisticExtDto getBlogCountStatistic(Long authorId) {
        return execute(getCommand(GetBlogCountStatisticCmd.class).setAuthorId(authorId));
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
