package com.littlefisher.blog.biz.cmd.tag;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.TagDtoConverter;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.common.enums.EnumTagState;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.model.TagDto;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

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
public class GetTagByNameCmd extends AbstractCommand<TagBizDto> {

    /** 标签名 */
    private String name;

    @Autowired
    private ITagDtoDao tagDtoDao;

    public GetTagByNameCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TagBizDto execute() {
        TagDto tagDto = tagDtoDao
            .selectOneByRecord(TagDto.Builder.getInstance().addName(name).addState(EnumTagState.VALID).build());
        return TagDtoConverter.convert2TagBizDto(tagDto);
    }
}
