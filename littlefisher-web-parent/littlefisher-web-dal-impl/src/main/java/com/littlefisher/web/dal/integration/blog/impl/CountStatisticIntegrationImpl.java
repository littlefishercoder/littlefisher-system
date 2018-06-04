package com.littlefisher.web.dal.integration.blog.impl;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;
import com.littlefisher.blog.biz.service.ICountStatisticService;
import com.littlefisher.web.dal.integration.blog.ICountStatisticIntegration;

/**
 * Description: CountStatisticIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class CountStatisticIntegrationImpl implements ICountStatisticIntegration {

    @Reference
    private ICountStatisticService countStatisticService;

    @Override
    public CountStatisticBizExtDto getBlogCountStatistic(Long authorId) {
        return countStatisticService.getBlogCountStatistic(authorId);
    }

    @Override
    public CountStatisticBizExtDto getPostCountStatistic(Long postId) {
        return countStatisticService.getPostCountStatistic(postId);
    }

    @Override
    public void addBlogCountTimes(AddBlogCountTimesRequest request) {
        countStatisticService.addBlogCountTimes(request);
    }

    @Override
    public void addPostCountTimes(AddPostCountTimesRequest request) {
        countStatisticService.addPostCountTimes(request);
    }
}
