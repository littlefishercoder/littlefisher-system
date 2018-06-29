package com.littlefisher.web.dal.integration.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.blog.biz.service.ITagService;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.web.dal.integration.blog.ITagIntegration;

/**
 * Description: TagIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class TagIntegrationImpl implements ITagIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ITagService tagService;

    @Override
    public PageInfo<TagBizDto> getTagList4PageByCond(GetTagList4PageByCondRequest request) {
        return tagService.getTagList4PageByCond(request);
    }

    @Override
    public TagBizDto getTagByName(String name) {
        return tagService.getTagByName(name);
    }

    @Override
    public TagBizDto addTag(String name) {
        return tagService.addTag(name);
    }

    @Override
    public PostTagBizDto linkPostAndTag(PostTagBizDto postTagDto) {
        return tagService.linkPostAndTag(postTagDto);
    }
}
