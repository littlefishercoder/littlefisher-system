package com.littlefisher.blog.service;

import com.littlefisher.blog.model.ext.CountStatisticExtDto;
import com.littlefisher.blog.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.request.AddPostCountTimesRequest;

/**
 * Description: ICountStatisticService.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ICountStatisticService {

    /**
     * 查询针对于博客的数量统计
     * @param authorId 作者id
     * @return 数量统计
     */
    CountStatisticExtDto getBlogCountStatistic(Long authorId);

    /**
     * 查询针对于博文的数量统计
     * @param postId 博文id
     * @return 数量统计
     */
    CountStatisticExtDto getPostCountStatistic(Long postId);

    /**
     * 增加博客相关统计数据
     * @param request 请求
     */
    void addBlogCountTimes(AddBlogCountTimesRequest request);

    /**
     * 增加博文相关统计数据
     * @param request 请求
     */
    void addPostCountTimes(AddPostCountTimesRequest request);
}
