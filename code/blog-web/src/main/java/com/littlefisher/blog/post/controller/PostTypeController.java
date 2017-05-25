package com.littlefisher.blog.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.post.model.PostTypeDto;
import com.littlefisher.blog.post.service.IPostTypeService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
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
     * 
     * Description: 查询所有博文类型
     * 
     * @author jinyanan
     *
     * @return List<PostTypeDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有博文类型")
    public List<PostTypeDto> getAllPostType() throws BaseAppException {
        return postTypeService.getAllPostType();
    }

    /**
     * 
     * Description: 新增博文类型
     * 
     * @author jinyanan
     *
     * @param postTypeDto postTypeDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文类型")
    public PostTypeDto addPostType(
        @ApiParam(required = true, value = "博文类型实体") @RequestBody PostTypeDto postTypeDto) throws BaseAppException {
        return postTypeService.addPostType(postTypeDto);
    }

    /**
     * 
     * Description: 修改博文类型
     * 
     * @author jinyanan
     *
     * @param postTypeDto postTypeDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文类型")
    public PostTypeDto updatePostType(
        @ApiParam(required = true, value = "博文类型实体") @RequestBody PostTypeDto postTypeDto) throws BaseAppException {
        return postTypeService.updatePostType(postTypeDto);
    }
    
    /**
     * 
     * Description: 删除博文类型
     * 
     * @author jinyanan
     *
     * @param type type
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{type}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文类型")
    public int deletePostType(
        @ApiParam(required = true, value = "博文类型") @PathVariable("type") String type) throws BaseAppException {
        return postTypeService.deletePostType(type);
    }
}
