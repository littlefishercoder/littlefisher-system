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
public class GetPostByIdCmd extends AbstractCommand<PostDto> {
    
    /**
     * postId
     */
    private Long postId;
    
    /**
     * 
     * Description: 
     *
     * @author jinyanan
     *
     * @param postId postId
     */
    public GetPostByIdCmd(Long postId) {
        super();
        this.postId = postId;
    }

    @Override
    public PostDto execute() throws BaseAppException {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        return postDtoMapper.selectByPrimaryKey(postId);
    }

}
