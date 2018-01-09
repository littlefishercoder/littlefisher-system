package com.littlefisher.blog.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description: getPostWithoutBlobByIdCmd.java
 *
 * Created on 2018年01月09日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetPostWithoutBlobByIdCmd extends AbstractCommand<PostDto> {

    /** 博文id */
    private Long postId;

    @Autowired
    private PostDtoMapper postDtoMapper;

    public GetPostWithoutBlobByIdCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public PostDto execute() {
//        return postDtoMapper.select;
        return null;
    }
}
