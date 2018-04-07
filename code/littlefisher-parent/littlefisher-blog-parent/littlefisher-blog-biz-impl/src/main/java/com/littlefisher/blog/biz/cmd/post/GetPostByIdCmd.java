package com.littlefisher.blog.biz.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.PostDtoConverter;
import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

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
public class GetPostByIdCmd extends AbstractCommand<PostBizDto> {

    /**
     * postId
     */
    private Long postId;

    @Autowired
    private IPostDtoDao postDtoDao;

    public GetPostByIdCmd setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public PostBizDto execute() {
        PostDto post = postDtoDao.selectByPrimaryKey(postId);
        return PostDtoConverter.convert2PostBizDto(post);
    }

}
