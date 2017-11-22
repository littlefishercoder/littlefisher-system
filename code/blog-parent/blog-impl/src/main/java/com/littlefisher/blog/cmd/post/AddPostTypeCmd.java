package com.littlefisher.blog.cmd.post;

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
public class AddPostTypeCmd extends AbstractCommand<PostTypeDto> {

    /**
     * postTypeDto
     */
    private PostTypeDto postTypeDto;

    /**
     * Description: 构造函数
     *
     * @param postTypeDto postTypeDto
     */
    public AddPostTypeCmd(PostTypeDto postTypeDto) {
        super();
        this.postTypeDto = postTypeDto;
    }

    @Override
    public PostTypeDto execute() {
        PostTypeDtoMapper postTypeDtoMapper = this.getMapper(PostTypeDtoMapper.class);
        postTypeDtoMapper.insert(postTypeDto);
        return postTypeDto;
    }

}
