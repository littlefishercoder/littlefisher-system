package com.littlefisher.blog.cmd.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.TagDtoMapper;
import com.littlefisher.blog.enums.EnumTagState;
import com.littlefisher.blog.example.TagDtoExample;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.CollectionUtil;

/**
 * Description: GetTagByNameCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetTagByNameCmd extends AbstractCommand<TagDto> {

    /** 标签名 */
    private String name;

    @Autowired
    private TagDtoMapper tagDtoMapper;

    public GetTagByNameCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TagDto execute() {
        TagDtoExample tagDtoExample = new TagDtoExample();
        tagDtoExample.createCriteria().andNameEqualTo(name).andStateEqualTo(EnumTagState.VALID);
        List<TagDto> tagList = tagDtoMapper.selectByExample(tagDtoExample);
        return CollectionUtil.isEmpty(tagList) ? null : tagList.get(0);
    }
}
