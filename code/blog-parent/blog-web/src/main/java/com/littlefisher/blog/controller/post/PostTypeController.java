package com.littlefisher.blog.controller.post;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.intf.post.IPostTypeService;
import com.littlefisher.blog.model.post.PostTypeDto;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/post/postTypes")
@Api(value = "postTypes", description = "postTypes 接口API")
public class PostTypeController {

    /**
     * postTypeService
     */
    @Autowired
    private IPostTypeService postTypeService;

    /**
     * Description: 查询所有博文类型
     *
     * @return List<PostTypeDto>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有博文类型")
    public List<PostTypeDto> getAllPostType() {
        return postTypeService.getAllPostType();
    }

    /**
     * Description: 新增博文类型
     *
     * @param postTypeDto postTypeDto
     * @return PostStateDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文类型")
    public PostTypeDto addPostType(
            @ApiParam(required = true, value = "博文类型实体") @RequestBody PostTypeDto postTypeDto) {
        return postTypeService.addPostType(postTypeDto);
    }

    /**
     * Description: 修改博文类型
     *
     * @param postTypeDto postTypeDto
     * @return PostStateDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文类型")
    public PostTypeDto updatePostType(
            @ApiParam(required = true, value = "博文类型实体") @RequestBody PostTypeDto postTypeDto) {
        return postTypeService.updatePostType(postTypeDto);
    }

    /**
     * Description: 删除博文类型
     *
     * @param type type
     * @return int
     */
    @RequestMapping(value = "/{type}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文类型")
    public int deletePostType(
            @ApiParam(required = true, value = "博文类型") @PathVariable("type") String type) {
        return postTypeService.deletePostType(type);
    }
}
