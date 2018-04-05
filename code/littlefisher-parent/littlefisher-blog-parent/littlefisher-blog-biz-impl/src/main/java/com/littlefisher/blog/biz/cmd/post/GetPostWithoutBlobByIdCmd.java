package com.littlefisher.blog.biz.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.PostDtoConverter;
import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

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
public class GetPostWithoutBlobByIdCmd extends AbstractCommand<PostBizDto> {

    /** 博文id */
    private Long postId;

    @Autowired
    private IPostDtoDao postDtoDao;

    public GetPostWithoutBlobByIdCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public PostBizDto execute() {
        PostDto postDto = postDtoDao.selectOneWithoutBlobByRecord(PostDto.Builder.getInstance().addId(postId).build());
        return PostDtoConverter.convert2PostBizDto(postDto);
    }
}
