package com.littlefisher.blog.post.cmd;

import java.util.List;

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
public class GetAllPostTypeCmd extends AbstractCommand<List<PostTypeDto>> {

    @Override
    public List<PostTypeDto> execute() throws BaseAppException {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        return postTypeDtoMapper.selectAll();
    }

}
