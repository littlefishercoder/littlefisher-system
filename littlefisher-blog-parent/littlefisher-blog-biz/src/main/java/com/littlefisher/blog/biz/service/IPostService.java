package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;

/**
 * Description: 博文接口
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "post-service", path = "/posts")
public interface IPostService {

    /**
     * 根据条件分页查询博文列表
     * 
     * @param req req
     * @return 博文列表
     */
    @GetMapping("/page")
    PageInfo<PostBizExtDto> getPostList4PageByCond(@JsonArgument("request") GetPostList4PageByCondRequest req);

    /**
     * 根据id查询博文信息
     * 
     * @param postId postId
     * @return PostDto
     */
    @GetMapping("/{postId}")
    PostBizDto getPostById(@PathVariable("postId") Long postId);

    /**
     * 根据id查询博文，不带博文全文
     * 
     * @param postId 博文id
     * @return 博文实体
     */
    @GetMapping("/{postId}")
    PostBizDto getPostWithoutBlobById(@PathVariable("postId") Long postId);

    /**
     * 新增博文
     *
     * @param request request
     */
    @PostMapping
    void addPost(@RequestBody AddPostRequest request);

    /**
     * 修改博文
     * 
     * @param request postDto
     * @return PostDto
     */
    @PatchMapping
    PostBizDto updatePost(@RequestBody UpdatePostRequest request);

    /**
     * 删除博文
     *
     * @param postId postId
     * @return int
     */
    @DeleteMapping("/{postId}")
    int deletePostById(@PathVariable("postId") Long postId);

}
