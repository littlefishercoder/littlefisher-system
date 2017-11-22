package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.post.PostDtoMapper;
import com.littlefisher.blog.model.post.PostDto;
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
public class GetPostByIdCmd extends AbstractCommand<PostDto> {

    /**
     * postId
     */
    private Long postId;

    /**
     * Description: 构造函数
     *
     * @param postId postId
     */
    public GetPostByIdCmd(Long postId) {
        super();
        this.postId = postId;
    }

    @Override
    public PostDto execute() {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        return postDtoMapper.selectByPrimaryKey(postId);
    }

}
