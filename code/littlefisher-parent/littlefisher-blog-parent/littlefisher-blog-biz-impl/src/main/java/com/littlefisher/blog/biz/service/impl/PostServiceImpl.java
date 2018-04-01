package com.littlefisher.blog.biz.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.blog.biz.cmd.post.AddPostCmd;
import com.littlefisher.blog.biz.cmd.post.DeletePostByIdCmd;
import com.littlefisher.blog.biz.cmd.post.GetPostByIdCmd;
import com.littlefisher.blog.biz.cmd.post.GetPostList4PagerByCondCmd;
import com.littlefisher.blog.biz.cmd.post.GetPostWithoutBlobByIdCmd;
import com.littlefisher.blog.biz.cmd.post.UpdatePostCmd;
import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.request.UpdatePostRequest;
import com.littlefisher.blog.biz.service.IPostService;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Service(interfaceClass = IPostService.class)
public class PostServiceImpl extends ServiceImpl implements IPostService {

    @Override
    public PageInfo<PostBizExtDto> getPostList4PageByCond(GetPostList4PageByCondRequest req) {
        return this.execute(getCommand(GetPostList4PagerByCondCmd.class).setReq(req));
    }

    @Override
    public PostBizDto getPostById(Long postId) {
        return this.execute(getCommand(GetPostByIdCmd.class).setPostId(postId));
    }

    @Override
    public PostBizDto getPostWithoutBlobById(Long postId) {
        return this.execute(getCommand(GetPostWithoutBlobByIdCmd.class).setPostId(postId));
    }

    @Override
    public void addPost(AddPostRequest request) {
        this.execute(getCommand(AddPostCmd.class).setRequest(request));
    }

    @Override
    public PostBizDto updatePost(UpdatePostRequest request) {
        PostBizDto postDto = this.getPostById(request.getId());
        postDto.setTitle(request.getTitle());
        postDto.setOriginalUrl(request.getOriginalUrl());
        postDto.setType(request.getType());
        postDto.setArchiveId(request.getArchiveId());
        postDto.setEnableComment(request.getEnableComment());
        if (request.getState() != null) {
            postDto.setState(request.getState());
            postDto.setStateDate(DateUtil.getDBDateTime());
        }
        postDto.setContent(request.getContent());
        return this.execute(getCommand(UpdatePostCmd.class).setPostDto(postDto));
    }

    @Override
    public int deletePostById(Long postId) {
        return this.execute(getCommand(DeletePostByIdCmd.class).setPostId(postId));
    }

}
