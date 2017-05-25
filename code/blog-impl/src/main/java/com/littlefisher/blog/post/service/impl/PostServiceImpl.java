package com.littlefisher.blog.post.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.post.cmd.AddPostCmd;
import com.littlefisher.blog.post.cmd.DeletePostByIdCmd;
import com.littlefisher.blog.post.cmd.GetPostByIdCmd;
import com.littlefisher.blog.post.cmd.GetPostList4PagerByCondCmd;
import com.littlefisher.blog.post.cmd.UpdatePostCmd;
import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;
import com.littlefisher.blog.post.service.IPostService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
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
    public List<PostDto> getPostList4PagerByCond(GetPostList4PagerByCondRequest req) throws BaseAppException {
        return this.execute(new GetPostList4PagerByCondCmd(req));
    }

    @Override
    public PostDto getPostById(Long postId) throws BaseAppException {
        return this.execute(new GetPostByIdCmd(postId));
    }

    @Override
    public PostDto addPost(PostDto postDto) throws BaseAppException {
        return this.execute(new AddPostCmd(postDto));
    }

    @Override
    public PostDto updatePost(PostDto postDto) throws BaseAppException {
        return this.execute(new UpdatePostCmd(postDto));
    }

    @Override
    public int deletePostById(Long postId) throws BaseAppException {
        return this.execute(new DeletePostByIdCmd(postId));
    }


}
