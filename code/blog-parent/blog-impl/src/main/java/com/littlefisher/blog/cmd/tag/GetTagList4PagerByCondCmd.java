package com.littlefisher.blog.cmd.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.ext.TagDtoExtMapper;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description: GetTagList4PagerByCondCmd.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetTagList4PagerByCondCmd extends AbstractCommand<List<TagDto>> {

    private GetTagList4PagerByCondRequest request;

    @Autowired
    private TagDtoExtMapper tagDtoExtMapper;

    public GetTagList4PagerByCondCmd setRequest(GetTagList4PagerByCondRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public List<TagDto> execute() {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        return tagDtoExtMapper.selectByCond(request);
    }
}
