package com.littlefisher.blog.cmd.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.PostTagDtoMapper;
import com.littlefisher.blog.enums.EnumPostTagState;
import com.littlefisher.blog.example.PostTagDtoExample;
import com.littlefisher.blog.model.PostTagDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.DateUtil;

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
public class LinkPostAndTagCmd extends AbstractCommand<PostTagDto> {

    /** 博文标签关联 */
    private PostTagDto postTag;

    @Autowired
    private PostTagDtoMapper postTagDtoMapper;

    public LinkPostAndTagCmd setPostTag(PostTagDto postTag) {
        this.postTag = postTag;
        return this;
    }

    @Override
    public PostTagDto execute() {
        PostTagDtoExample postTagDtoExample = new PostTagDtoExample();
        postTagDtoExample.createCriteria().andPostIdEqualTo(postTag.getPostId()).andTagIdEqualTo(postTag.getTagId())
                .andStateEqualTo(EnumPostTagState.VALID);
        List<PostTagDto> postTagList = postTagDtoMapper.selectByExample(postTagDtoExample);
        if (CollectionUtil.isEmpty(postTagList)) {
            postTag.setState(EnumPostTagState.VALID);
            postTag.setCreateDate(DateUtil.getDBDateTime());
            postTag.setUpdateDate(DateUtil.getDBDateTime());
            postTagDtoMapper.insert(postTag);
            return postTag;
        } else {
            return postTagList.get(0);
        }
    }
}
