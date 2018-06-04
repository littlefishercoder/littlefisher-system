package com.littlefisher.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.biz.model.CountStatisticBizExtDto;
import com.littlefisher.blog.biz.request.AddBlogCountTimesRequest;
import com.littlefisher.blog.biz.request.AddPostCountTimesRequest;
import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.web.dal.integration.blog.ICountStatisticIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

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
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/countStatistics")
@Api(value = "countStatistics", description = "countStatistics 接口API")
public class CountStatisticController {

    @Autowired
    private ICountStatisticIntegration countStatisticIntegration;

    /**
     * 查询博客相关数量统计
     *
     * @param authorId 作者id
     * @return 统计信息
     */
    @RequestMapping(value = "/blog/{authorId}", method = RequestMethod.GET)
    @ApiOperation("查询博客相关数量统计")
    public CountStatisticBizExtDto getBlogCountStatistic(
            @ApiParam(required = true, value = "作者id") @PathVariable("authorId") @NotNull(message = "作者id不能为空")
            @NotBlank(message = "作者id不能为空") Long authorId) {
        // 查询博客相关数量统计
        return countStatisticIntegration.getBlogCountStatistic(authorId);
    }

    /**
     * 增加博客统计信息
     *
     * @param request 请求入参
     */
    @RequestMapping(value = "/blog", method = RequestMethod.PATCH)
    public void addBlogCountTimes(
            @ApiParam(required = true, value = "增加博客统计信息") @RequestBody @NotNull(message = "请求不能为空") AddBlogCountTimesRequest request) {
        // 增加博客统计信息
        countStatisticIntegration.addBlogCountTimes(request);
    }

    /**
     * 增加博文统计数据
     *
     * @param request 请求入参
     */
    @RequestMapping(value = "/post", method = RequestMethod.PATCH)
    public void addPostCountTimes(
            @ApiParam(required = true, value = "增加博文统计数据") @RequestBody @NotNull(message = "请求不能为空") AddPostCountTimesRequest request) {
        // 增加博文统计数据
        countStatisticIntegration.addPostCountTimes(request);
    }

}
