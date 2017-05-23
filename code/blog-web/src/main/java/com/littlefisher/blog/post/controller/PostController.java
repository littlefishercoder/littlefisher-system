package com.littlefisher.blog.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;
import com.littlefisher.blog.post.service.IPostService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 博文Controller
 *  
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
     * 
     * Description: 根据条件查询博文列表
     * 
     * @author jinyanan
     *
     * @param req req
     * @return PageInfo<PostDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation("根据条件查询博文列表")
    public PageInfo<PostDto> getPostList4PagerByCond(
        @ApiParam(required = true, value = "查询博文列表的条件") @ModelAttribute GetPostList4PagerByCondRequest req) throws BaseAppException {
        List<PostDto> postList = postService.getPostList4PagerByCond(req);
        return new PageInfo<>(postList);
    }
    
    /**
     * 
     * Description: 根据博文主键查询具体博文
     * 
     * @author jinyanan
     *
     * @param postId postId
     * @return PostDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    @ApiOperation("根据博文主键查询具体博文")
    public PostDto getPostById(
        @ApiParam(required = true, value = "博文主键") @PathVariable("postId") Long postId) throws BaseAppException {
        return postService.getPostById(postId);
    }
    
    /**
     * 
     * Description: 新增博文
     * 
     * @author jinyanan
     *
     * @param postDto 博文实体
     * @return PostDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文")
    public PostDto addPost(
        @ApiParam(required = true, value = "博文实体") @RequestBody PostDto postDto) throws BaseAppException {
        return postService.addPost(postDto);
    }
    
    /**
     * 
     * Description: 修改博文
     * 
     * @author jinyanan
     *
     * @param postDto 博文实体
     * @return PostDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文")
    public PostDto updatePost(
        @ApiParam(required = true, value = "博文实体") @RequestBody PostDto postDto) throws BaseAppException {
        return postService.updatePost(postDto);
    }
    
    /**
     * 
     * Description: 删除博文
     * 
     * @author jinyanan
     *
     * @param postId postId
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文")
    public int deletePost(
        @ApiParam(required = true, value = "博文主键") @PathVariable("postId") Long postId) throws BaseAppException {
        return postService.deletePostById(postId);
    }

}
