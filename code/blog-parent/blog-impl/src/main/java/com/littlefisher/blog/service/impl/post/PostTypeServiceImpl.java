package com.littlefisher.blog.service.impl.post;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.post.AddPostTypeCmd;
import com.littlefisher.blog.cmd.post.DeletePostTypeCmd;
import com.littlefisher.blog.cmd.post.GetAllPostTypeCmd;
import com.littlefisher.blog.cmd.post.UpdatePostTypeCmd;
import com.littlefisher.blog.intf.post.IPostTypeService;
import com.littlefisher.blog.model.post.PostTypeDto;
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
public class PostTypeServiceImpl extends ServiceImpl implements IPostTypeService {

    @Override
    public List<PostTypeDto> getAllPostType() {
        return this.execute(new GetAllPostTypeCmd());
    }

    @Override
    public PostTypeDto addPostType(PostTypeDto postTypeDto) {
        return this.execute(new AddPostTypeCmd(postTypeDto));
    }

    @Override
    public PostTypeDto updatePostType(PostTypeDto postTypeDto) {
        return this.execute(new UpdatePostTypeCmd(postTypeDto));
    }

    @Override
    public int deletePostType(String type) {
        return this.execute(new DeletePostTypeCmd(type));
    }

}
