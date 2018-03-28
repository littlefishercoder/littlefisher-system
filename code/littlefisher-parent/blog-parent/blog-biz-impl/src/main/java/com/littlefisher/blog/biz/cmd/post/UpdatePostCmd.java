package com.littlefisher.blog.biz.cmd.post;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.PostDtoConverter;
import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.model.PostDto;
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
public class UpdatePostCmd extends AbstractCommand<PostBizDto> {

    /**
     * postDto
     */
    private PostBizDto postBizDto;

    @Autowired
    private IPostDtoDao postDtoDao;

    public UpdatePostCmd setPostDto(PostBizDto postBizDto) {
        this.postBizDto = postBizDto;
        return this;
    }

    @Override
    public PostBizDto execute() {
        PostDto postDto = postDtoDao.updateByPrimaryKey(PostDtoConverter.convert2PostDto(postBizDto));
        return PostDtoConverter.convert2PostBizDto(postDto);
    }

}
