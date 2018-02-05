package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;
import com.littlefisher.blog.service.ITagService;
import com.littlefisher.core.stereotype.constants.BaseConstants;

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
    private ITagService tagService;

    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation("查询tag列表，分页用")
    public PageInfo<TagDto> getTagList4PagerByCond(
            @ApiParam(value = "查询tag列表条件") @ModelAttribute @NotNull(message = "请求不能为空")
                    GetTagList4PagerByCondRequest request) {
        List<TagDto> tagList = tagService.getTagList4PagerByCond(request);
        return new PageInfo<>(tagList);
    }
}
