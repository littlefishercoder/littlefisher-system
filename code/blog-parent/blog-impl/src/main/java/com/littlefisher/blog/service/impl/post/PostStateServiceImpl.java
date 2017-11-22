package com.littlefisher.blog.service.impl.post;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.post.AddPostStateCmd;
import com.littlefisher.blog.cmd.post.DeletePostStateCmd;
import com.littlefisher.blog.cmd.post.GetAllPostStateCmd;
import com.littlefisher.blog.cmd.post.UpdatePostStateCmd;
import com.littlefisher.blog.intf.post.IPostStateService;
import com.littlefisher.blog.model.post.PostStateDto;
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
