package com.littlefisher.blog.biz.cmd.tag;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.TagDtoConverter;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.service.ITagService;
import com.littlefisher.blog.common.enums.EnumTagState;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.model.TagDto;
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
public class AddTagCmd extends AbstractCommand<TagBizDto> {

    /** 标签名 */
    private String name;

    @Autowired
    private ITagDtoDao tagDtoDao;

    @Autowired
    private ITagService tagService;

    public AddTagCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TagBizDto execute() {
        TagBizDto tagBizDto = tagService.getTagByName(name);
        if (tagBizDto == null) {
            TagDto tagDto = TagDto.Builder.getInstance()
                    .addName(name)
                    .addState(EnumTagState.VALID)
                    .addStateDate(DateUtil.getDBDateTime())
                    .addCreateDate(DateUtil.getDBDateTime())
                    .build();
            tagDtoDao.insert(tagDto);
            return TagDtoConverter.convert2TagBizDto(tagDto);
        } else {
            return tagBizDto;
        }
    }
}
