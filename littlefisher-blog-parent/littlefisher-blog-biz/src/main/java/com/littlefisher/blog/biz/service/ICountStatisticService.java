package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;

/**
 * Description: ICountStatisticService.java
 *
 * Created on 2018年01月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "count-statistic-service", path = "/countStatistics")
public interface ICountStatisticService {

    /**
     * 查询针对于博客的数量统计
     * 
     * @param authorId 作者id
     * @return 数量统计
     */
    @GetMapping("/blog/{authorId}")
    CountStatisticBizExtDto getBlogCountStatistic(@PathVariable("authorId") Long authorId);

    /**
     * 查询针对于博文的数量统计
     * 
     * @param postId 博文id
     * @return 数量统计
     */
    @GetMapping("/post/{postId}")
    CountStatisticBizExtDto getPostCountStatistic(@PathVariable("postId") Long postId);

    /**
     * 增加博客相关统计数据
     * 
     * @param request 请求
     */
    @PostMapping("/blog")
    void addBlogCountTimes(@RequestBody AddBlogCountTimesRequest request);

    /**
     * 增加博文相关统计数据
     * 
     * @param request 请求
     */
    @PostMapping("/post")
    void addPostCountTimes(@RequestBody AddPostCountTimesRequest request);
}
