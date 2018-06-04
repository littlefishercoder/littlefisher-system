package com.littlefisher.web.dal.integration.blog;

import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;

/**
 * Description: ICountStatisticIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ICountStatisticIntegration {

    /**
     * 查询针对于博客的数量统计
     * @param authorId 作者id
     * @return 数量统计
     */
    CountStatisticBizExtDto getBlogCountStatistic(Long authorId);

    /**
     * 查询针对于博文的数量统计
     * @param postId 博文id
     * @return 数量统计
     */
    CountStatisticBizExtDto getPostCountStatistic(Long postId);

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
