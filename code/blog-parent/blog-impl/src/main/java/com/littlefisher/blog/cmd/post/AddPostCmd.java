package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AddPostCmd extends AbstractCommand<PostDto> {

    /**
     * postDto
     */
    private PostDto postDto;

    /**
     * Description: 构造函数
     *
     * @param postDto postDto
     */
    public AddPostCmd(PostDto postDto) {
        super();
        this.postDto = postDto;
    }

    @Override
    public PostDto execute() {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        postDtoMapper.insert(postDto);
        return postDto;
    }

}
