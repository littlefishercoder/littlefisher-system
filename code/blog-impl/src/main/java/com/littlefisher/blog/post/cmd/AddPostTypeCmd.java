package com.littlefisher.blog.post.cmd;

import com.littlefisher.blog.post.dao.PostTypeDtoMapper;
import com.littlefisher.blog.post.model.PostTypeDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

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
public class AddPostTypeCmd extends AbstractCommand<PostTypeDto> {
    
    /**
     * postTypeDto
     */
    private PostTypeDto postTypeDto;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param postTypeDto postTypeDto 
     */ 
    public AddPostTypeCmd(PostTypeDto postTypeDto) {
        super();
        this.postTypeDto = postTypeDto;
    }

    @Override
    public PostTypeDto execute() throws BaseAppException {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        postTypeDtoMapper.insert(postTypeDto);
        return postTypeDto;
    }

}
