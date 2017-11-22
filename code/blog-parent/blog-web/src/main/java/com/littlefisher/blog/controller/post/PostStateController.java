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

import com.littlefisher.blog.intf.post.IPostStateService;
import com.littlefisher.blog.model.post.PostStateDto;

/**
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
     * Description: 查询所有博文状态
     *
     * @return List<PostStateDto>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有博文状态")
    public List<PostStateDto> getAllPostState() {
        return postStateService.getAllPostState();
    }

    /**
     * Description: 新增博文状态
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文状态")
    public PostStateDto addPostState(
            @ApiParam(required = true, value = "博文状态实体") @RequestBody PostStateDto postStateDto) {
        return postStateService.addPostState(postStateDto);
    }

    /**
     * Description: 修改博文状态
     *
     * @param postStateDto postStateDto
     * @return PostStateDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文状态")
    public PostStateDto updatePostState(
            @ApiParam(required = true, value = "博文状态实体") @RequestBody PostStateDto postStateDto) {
        return postStateService.updatePostState(postStateDto);
    }

    /**
     * Description: 删除博文状态
     *
     * @param state state
     * @return int
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文状态")
    public int deletePostState(
            @ApiParam(required = true, value = "博文状态") @PathVariable("state") String state) {
        return postStateService.deletePostState(state);
    }

}
