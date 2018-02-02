package com.littlefisher.blog.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class DeletePostByIdCmd extends AbstractCommand<Integer> {

    /**
     * postId
     */
    private Long postId;

    @Autowired
    private PostDtoMapper postDtoMapper;

    public DeletePostByIdCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public Integer execute() {
        return postDtoMapper.deleteByPrimaryKey(postId);
    }

}
