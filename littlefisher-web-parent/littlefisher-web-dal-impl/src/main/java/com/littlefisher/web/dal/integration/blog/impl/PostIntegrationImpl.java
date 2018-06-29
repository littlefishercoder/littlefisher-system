package com.littlefisher.web.dal.integration.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.blog.biz.service.IPostService;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.web.dal.integration.blog.IPostIntegration;

/**
 * Description: PostIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class PostIntegrationImpl implements IPostIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private IPostService postService;

    @Override
    public PageInfo<PostBizExtDto> getPostList4PageByCond(GetPostList4PageByCondRequest req) {
        return postService.getPostList4PageByCond(req);
    }

    @Override
    public PostBizDto getPostById(Long postId) {
        return postService.getPostById(postId);
    }

    @Override
    public PostBizDto getPostWithoutBlobById(Long postId) {
        return postService.getPostWithoutBlobById(postId);
    }

    @Override
    public void addPost(AddPostRequest request) {
        postService.addPost(request);
    }

    @Override
    public PostBizDto updatePost(UpdatePostRequest request) {
        return postService.updatePost(request);
    }

    @Override
    public int deletePostById(Long postId) {
        return postService.deletePostById(postId);
    }
}
