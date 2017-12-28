package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.model.ext.CountStatisticExtDto;
import com.littlefisher.blog.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.request.AddPostCountTimesRequest;

/**
 * Description: CountStatisticController.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/countStatistics")
@Api(value = "countStatistics", description = "countStatistics 接口API")
public class CountStatisticController {

    /**
     * 查询博客相关数量统计
     *
     * @param authorId 作者id
     * @return 统计信息
     */
    @RequestMapping(value = "/blog/{authorId}", method = RequestMethod.GET)
    @ApiOperation("查询博客相关数量统计")
    public CountStatisticExtDto getBlogCountStatistic(
            @ApiParam(required = true, value = "作者id") @PathVariable("authorId") String authorId) {
        // TODO: 查询博客相关数量统计
        return null;
    }

    /**
     * 增加博客统计信息
     *
     * @param request 请求入参
     */
    @RequestMapping(value = "/blog", method = RequestMethod.PATCH)
    public void addBlogCountTimes(
            @ApiParam(required = true, value = "增加博客统计信息") @RequestBody AddBlogCountTimesRequest request) {
        // TODO: 增加博客统计信息
    }

    /**
     * 增加博文统计数据
     *
     * @param request 请求入参
     */
    @RequestMapping(value = "/post", method = RequestMethod.PATCH)
    public void addPostCountTimes(
            @ApiParam(required = true, value = "增加博文统计数据") @RequestBody AddPostCountTimesRequest request) {
        // TODO: 增加博文统计数据
    }

}
