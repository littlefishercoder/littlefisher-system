package com.littlefisher.blog.post.cmd;

import java.util.List;

import com.littlefisher.blog.post.dao.PostStateDtoMapper;
import com.littlefisher.blog.post.model.PostStateDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月24日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetAllPostStateCmd extends AbstractCommand<List<PostStateDto>> {

    @Override
    public List<PostStateDto> execute() throws BaseAppException {
        PostStateDtoMapper postStateDtoMapper = this.getMapper(PostStateDtoMapper.class);
        return postStateDtoMapper.selectAll();
    }

}
