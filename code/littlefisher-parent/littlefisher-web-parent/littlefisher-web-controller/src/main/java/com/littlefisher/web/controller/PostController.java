package com.littlefisher.web.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.stereotype.constants.BaseConstants;
import com.littlefisher.web.dal.integration.blog.IPostIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

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
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/posts")
@Api(value = "post", description = "post 接口API")
public class PostController {

    @Autowired
    private IPostIntegration postIntegration;

    /**
     * Description: 根据条件查询博文列表
     *
     * @param req req
     * @return PageInfo<PostDto>
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation("根据条件查询博文列表")
    public PageInfo<PostBizExtDto> getPostList4PageByCond(
            @ApiParam(required = true, value = "查询博文列表的条件") @ModelAttribute @NotNull(message = "请求不能为空") GetPostList4PageByCondRequest req) {
        return postIntegration.getPostList4PageByCond(req);
    }

    /**
     * Description: 根据博文主键查询具体博文
     *
     * @param postId postId
     * @return PostDto
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    @ApiOperation("根据博文主键查询具体博文")
    public PostBizDto getPostById(
            @ApiParam(required = true, value = "博文主键") @PathVariable("postId") @NotNull(message = "博文id不能为空")
            @NotBlank(message = "博文id不能为空") Long postId) {
        return postIntegration.getPostById(postId);
    }

    /**
     * Description: 新增博文
     *
     * @param request 博文实体
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增博文")
    public void addPost(@ApiParam(required = true, value = "博文实体") @RequestBody @NotNull(message = "请求不能为空") AddPostRequest request) {
        postIntegration.addPost(request);
    }

    /**
     * Description: 修改博文
     *
     * @param request 请求入参
     * @return PostDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改博文")
    public PostBizDto updatePost(@ApiParam(required = true, value = "博文实体") @RequestBody @NotNull(message = "修改博文请求不能为空") UpdatePostRequest request) {
        return postIntegration.updatePost(request);
    }

    /**
     * Description: 删除博文
     *
     * @param postId postId
     * @return int
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    @ApiOperation("删除博文")
    public int deletePost(
            @ApiParam(required = true, value = "博文主键") @PathVariable("postId") @NotNull(message = "博文id不能为空")
            @NotBlank(message = "博文id不能为空") Long postId) {
        return postIntegration.deletePostById(postId);
    }

}
