package com.littlefisher.blog.biz.service;

import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description: ITagService.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ITagService {

    /**
     * 根据条件分页查询标签
     *
     * @param request 入参
     * @return 标签列表
     */
    PageInfo<TagBizDto> getTagList4PageByCond(GetTagList4PageByCondRequest request);

    /**
     * 根据标签名查询标签
     * @param name 标签名
     * @return 标签实体
     */
    TagBizDto getTagByName(String name);

    /**
     * 新增标签
     * @param name 标签名
     * @return 标签
     */
    TagBizDto addTag(String name);

    /**
     * 给博文加标签
     * @param postTagDto 关联
     * @return PostTagDto
     */
    PostTagBizDto linkPostAndTag(PostTagBizDto postTagDto);
}
