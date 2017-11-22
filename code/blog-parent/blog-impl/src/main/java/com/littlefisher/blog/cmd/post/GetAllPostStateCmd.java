package com.littlefisher.blog.cmd.post;

import java.util.List;

import com.littlefisher.blog.dao.post.PostStateDtoMapper;
import com.littlefisher.blog.model.post.PostStateDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
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
    public List<PostStateDto> execute() {
        PostStateDtoMapper postStateDtoMapper = this.getMapper(PostStateDtoMapper.class);
        return postStateDtoMapper.selectAll();
    }

}
