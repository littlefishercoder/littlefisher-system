package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.post.PostDtoMapper;
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
public class DeletePostByIdCmd extends AbstractCommand<Integer> {

    /**
     * postId
     */
    private Long postId;

    /**
     * Description: 构造函数
     *
     * @param postId postId
     */
    public DeletePostByIdCmd(Long postId) {
        super();
        this.postId = postId;
    }

    @Override
    public Integer execute() {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        return postDtoMapper.deleteByPrimaryKey(postId);
    }

}
