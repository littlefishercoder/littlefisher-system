package com.littlefisher.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.post.AddPostCmd;
import com.littlefisher.blog.cmd.post.DeletePostByIdCmd;
import com.littlefisher.blog.cmd.post.GetPostByIdCmd;
import com.littlefisher.blog.cmd.post.GetPostList4PagerByCondCmd;
import com.littlefisher.blog.cmd.post.UpdatePostCmd;
import com.littlefisher.blog.service.IPostService;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class PostServiceImpl extends ServiceImpl implements IPostService {

    @Override
    public List<PostExtDto> getPostList4PagerByCond(GetPostList4PagerByCondRequest req) {
        return this.execute(new GetPostList4PagerByCondCmd(req));
    }

    @Override
    public PostDto getPostById(Long postId) {
        return this.execute(new GetPostByIdCmd(postId));
    }

    @Override
    public PostDto addPost(PostDto postDto) {
        return this.execute(new AddPostCmd(postDto));
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        return this.execute(new UpdatePostCmd(postDto));
    }

    @Override
    public int deletePostById(Long postId) {
        return this.execute(new DeletePostByIdCmd(postId));
    }

}
