package com.littlefisher.blog.cmd.tag;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.TagDtoMapper;
import com.littlefisher.blog.enums.EnumTagState;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.service.ITagService;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description: AddTagCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddTagCmd extends AbstractCommand<TagDto> {

    /** 标签名 */
    private String name;

    @Autowired
    private TagDtoMapper tagDtoMapper;

    @Autowired
    private ITagService tagService;

    public AddTagCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TagDto execute() {
        TagDto tagDto = tagService.getTagByName(name);
        if (tagDto == null) {
            tagDto = new TagDto();
            tagDto.setName(name);
            tagDto.setState(EnumTagState.VALID);
            tagDto.setStateDate(DateUtil.getDBDateTime());
            tagDto.setCreateDate(DateUtil.getDBDateTime());
            tagDtoMapper.insert(tagDto);
            return tagDto;
        } else {
            return tagDto;
        }
    }
}
