package com.littlefisher.blog.biz.cmd.tag;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.PostTagDtoConverter;
import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.common.enums.EnumPostTagState;
import com.littlefisher.blog.dal.dao.IPostTagDtoDao;
import com.littlefisher.blog.dal.model.PostTagDto;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.common.utils.DateUtil;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

/**
 * Description: LinkPostAndTagCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class LinkPostAndTagCmd extends AbstractCommand<PostTagBizDto> {

    /** 博文标签关联 */
    private PostTagBizDto postBizTag;

    @Autowired
    private IPostTagDtoDao postTagDtoDao;

    public LinkPostAndTagCmd setPostTag(PostTagBizDto postBizTag) {
        this.postBizTag = postBizTag;
        return this;
    }

    @Override
    public PostTagBizDto execute() {
        PostTagDto postTagDto
            = postTagDtoDao.selectOneByRecord(PostTagDto.Builder.getInstance().addPostId(postBizTag.getPostId())
                .addTagId(postBizTag.getTagId()).addState(EnumPostTagState.VALID).build());
        if (postTagDto == null) {
            postTagDto = PostTagDto.Builder.getInstance().addState(EnumPostTagState.VALID)
                .addCreateDate(DateUtil.getDBDateTime()).addUpdateDate(DateUtil.getDBDateTime()).build();
            postTagDtoDao.insert(postTagDto);
            return PostTagDtoConverter.convert2PostTagBizDto(postTagDto);
        } else {
            return PostTagDtoConverter.convert2PostTagBizDto(postTagDto);
        }
    }
}
