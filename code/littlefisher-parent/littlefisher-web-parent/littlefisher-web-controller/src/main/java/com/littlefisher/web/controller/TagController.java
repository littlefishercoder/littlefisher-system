package com.littlefisher.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.web.dal.integration.blog.ITagIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotNull;

/**
 * Description: TagController.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/tags")
@Api(value = "tag", description = "tag 接口API")
public class TagController {

    @Autowired
    private ITagIntegration tagIntegration;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation("查询tag列表，分页用")
    public PageInfo<TagBizDto> getTagList4PageByCond(
            @ApiParam(value = "查询tag列表条件") @ModelAttribute @NotNull(message = "请求不能为空") GetTagList4PageByCondRequest request) {
        return tagIntegration.getTagList4PageByCond(request);
    }
}
