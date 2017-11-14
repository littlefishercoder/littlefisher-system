package com.littlefisher.blog.post.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.post.cmd.AddPostStateCmd;
import com.littlefisher.blog.post.cmd.DeletePostStateCmd;
import com.littlefisher.blog.post.cmd.GetAllPostStateCmd;
import com.littlefisher.blog.post.cmd.UpdatePostStateCmd;
import com.littlefisher.blog.post.model.PostStateDto;
import com.littlefisher.blog.post.service.IPostStateService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class PostStateServiceImpl extends ServiceImpl implements IPostStateService {

    @Override
    public List<PostStateDto> getAllPostState() {
        return this.execute(new GetAllPostStateCmd());
    }

    @Override
    public PostStateDto addPostState(PostStateDto postStateDto) {
        return this.execute(new AddPostStateCmd(postStateDto));
    }

    @Override
    public PostStateDto updatePostState(PostStateDto postStateDto) {
        return this.execute(new UpdatePostStateCmd(postStateDto));
    }

    @Override
    public int deletePostState(String state) {
        return this.execute(new DeletePostStateCmd(state));
    }

}
