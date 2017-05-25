package com.littlefisher.blog.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.post.model.PostStateDto;
import com.littlefisher.blog.post.service.IPostStateService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 博文类型Controller
 *  
 * Created on 2017年5月25日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/post/postStates")
@Api(value = "postStates", description = "postStates 接口API")
public class PostStateController {
    
    /**
     * postStateService
     */
    @Autowired
    private IPostStateService postStateService;

    /**
     * 
     * Description: 查询所有博文状态
     * 
     * @author jinyanan
     *
     * @return List<PostStateDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有博文状态")
    public List<PostStateDto> getAllPostState() throws BaseAppException {
        return postStateService.getAllPostState();
    }

    /**
     * 
     * Description: 新增博文状态
     * 
     * @author jinyanan
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文状态")
    public PostStateDto addPostState(
        @ApiParam(required = true, value = "博文状态实体") @RequestBody PostStateDto postStateDto) throws BaseAppException {
        return postStateService.addPostState(postStateDto);
    }

    /**
     * 
     * Description: 修改博文状态
     * 
     * @author jinyanan
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文状态")
    public PostStateDto updatePostState(
        @ApiParam(required = true, value = "博文状态实体") @RequestBody PostStateDto postStateDto) throws BaseAppException {
        return postStateService.updatePostState(postStateDto);
    }
    
    /**
     * 
     * Description: 删除博文状态
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文状态")
    public int deletePostState(
        @ApiParam(required = true, value = "博文状态") @PathVariable("state") String state) throws BaseAppException {
        return postStateService.deletePostState(state);
    }

}
