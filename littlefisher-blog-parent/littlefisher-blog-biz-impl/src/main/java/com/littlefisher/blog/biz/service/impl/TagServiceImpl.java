package com.littlefisher.blog.biz.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.biz.cmd.tag.AddTagCmd;
import com.littlefisher.blog.biz.cmd.tag.GetTagByNameCmd;
import com.littlefisher.blog.biz.cmd.tag.GetTagList4PagerByCondCmd;
import com.littlefisher.blog.biz.cmd.tag.LinkPostAndTagCmd;
import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.blog.biz.service.ITagService;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description: TagServiceImpl.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class TagServiceImpl extends ServiceImpl implements ITagService {

    @Override
    public PageInfo<TagBizDto> getTagList4PageByCond(GetTagList4PageByCondRequest request) {
        return execute(getCommand(GetTagList4PagerByCondCmd.class).setRequest(request));
    }

    @Override
    public TagBizDto getTagByName(String name) {
        return execute(getCommand(GetTagByNameCmd.class).setName(name));
    }

    @Override
    public TagBizDto addTag(String name) {
        return execute(getCommand(AddTagCmd.class).setName(name));
    }

    @Override
    public PostTagBizDto linkPostAndTag(PostTagBizDto postTagDto) {
        return execute(getCommand(LinkPostAndTagCmd.class).setPostTag(postTagDto));
    }
}
