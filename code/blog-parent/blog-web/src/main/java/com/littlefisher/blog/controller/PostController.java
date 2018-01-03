package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.request.GetPostList4IndexPagerByCondRequest;
import com.littlefisher.blog.service.IPostService;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;

/**
 * Description: 博文Controller
 * <p>
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/posts")
@Api(value = "post", description = "post 接口API")
public class PostController {

    /**
     * postService
     */
    @Autowired
    private IPostService postService;

    /**
     * Description: 根据条件查询博文列表
     *
     * @param req req
     * @return PageInfo<PostDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation("根据条件查询博文列表")
    public PageInfo<PostExtDto> getPostList4PagerByCond(
            @ApiParam(required = true, value = "查询博文列表的条件") @ModelAttribute GetPostList4PagerByCondRequest req) {
        List<PostExtDto> postList = postService.getPostList4PagerByCond(req);
        return new PageInfo<>(postList);
    }

    /**
     *
     * 首页查询博文列表
     *
     * @param request 入参
     * @return 分页博文
     */
    @RequestMapping(value = "/index/pager", method = RequestMethod.GET)
    @ApiOperation("首页查询博文列表")
    public PageInfo<PostExtDto> getPostList4IndexPagerByCond(
            @ApiParam(required = true, value = "首页查询博文列表入参") @ModelAttribute
                    GetPostList4IndexPagerByCondRequest request) {
        // TODO: 首页博文分页列表，包含博文标签、博文分类、阅读数、点赞数、评论数等
        return null;
    }

    /**
     * Description: 根据博文主键查询具体博文
     *
     * @param postId postId
     * @return PostDto
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    @ApiOperation("根据博文主键查询具体博文")
    public PostDto getPostById(@ApiParam(required = true, value = "博文主键") @PathVariable("postId") Long postId) {
        return postService.getPostById(postId);
    }

    /**
     * Description: 新增博文
     *
     * @param postDto 博文实体
     * @return PostDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文")
    public PostDto addPost(@ApiParam(required = true, value = "博文实体") @RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    /**
     * Description: 修改博文
     *
     * @param postDto 博文实体
     * @return PostDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文")
    public PostDto updatePost(@ApiParam(required = true, value = "博文实体") @RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }

    /**
     * Description: 删除博文
     *
     * @param postId postId
     * @return int
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文")
    public int deletePost(@ApiParam(required = true, value = "博文主键") @PathVariable("postId") Long postId) {
        return postService.deletePostById(postId);
    }

}
