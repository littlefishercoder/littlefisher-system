package com.littlefisher.blog.service;

import java.util.List;

import com.littlefisher.blog.model.PostTagDto;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;

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
    List<TagDto> getTagList4PagerByCond(GetTagList4PagerByCondRequest request);

    /**
     * 根据标签名查询标签
     * @param name 标签名
     * @return 标签实体
     */
    TagDto getTagByName(String name);

    /**
     * 新增标签
     * @param name 标签名
     * @return 标签
     */
    TagDto addTag(String name);

    /**
     * 给博文加标签
     * @param postTagDto 关联
     * @return PostTagDto
     */
    PostTagDto linkPostAndTag(PostTagDto postTagDto);
}
