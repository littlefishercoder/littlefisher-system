package com.littlefisher.blog.cmd.post;

import java.util.List;

import com.littlefisher.blog.dao.post.PostTypeDtoMapper;
import com.littlefisher.blog.model.post.PostTypeDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
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
    public List<PostTypeDto> execute() {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        return postTypeDtoMapper.selectAll();
    }

}
