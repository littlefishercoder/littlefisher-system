package com.littlefisher.blog.post.cmd;

import com.littlefisher.blog.post.dao.PostDtoMapper;
import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

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
public class UpdatePostCmd extends AbstractCommand<PostDto> {
    
    /**
     * postDto
     */
    private PostDto postDto;

    /**
     * 
     * Description: 
     *
     * @author jinyanan
     *
     * @param postDto postDto
     */
    public UpdatePostCmd(PostDto postDto) {
        super();
        this.postDto = postDto;
    }

    @Override
    public PostDto execute() throws BaseAppException {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        postDtoMapper.updateByPrimaryKey(postDto);
        return postDto;
    }

}
