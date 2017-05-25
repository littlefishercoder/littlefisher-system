package com.littlefisher.blog.post.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.post.cmd.AddPostTypeCmd;
import com.littlefisher.blog.post.cmd.DeletePostTypeCmd;
import com.littlefisher.blog.post.cmd.GetAllPostTypeCmd;
import com.littlefisher.blog.post.cmd.UpdatePostTypeCmd;
import com.littlefisher.blog.post.model.PostTypeDto;
import com.littlefisher.blog.post.service.IPostTypeService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
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
    public List<PostTypeDto> getAllPostType() throws BaseAppException {
        return this.execute(new GetAllPostTypeCmd());
    }

    @Override
    public PostTypeDto addPostType(PostTypeDto postTypeDto) throws BaseAppException {
        return this.execute(new AddPostTypeCmd(postTypeDto));
    }

    @Override
    public PostTypeDto updatePostType(PostTypeDto postTypeDto) throws BaseAppException {
        return this.execute(new UpdatePostTypeCmd(postTypeDto));
    }

    @Override
    public int deletePostType(String type) throws BaseAppException {
        return this.execute(new DeletePostTypeCmd(type));
    }

}
