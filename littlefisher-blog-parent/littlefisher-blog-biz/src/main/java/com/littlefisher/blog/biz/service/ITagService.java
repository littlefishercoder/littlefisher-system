package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;

/**
 * Description: ITagService.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "tag-service", path = "/tags")
public interface ITagService {

    /**
     * 根据条件分页查询标签
     *
     * @param request 入参
     * @return 标签列表
     */
    @GetMapping("/page")
    PageInfo<TagBizDto> getTagList4PageByCond(@JsonArgument("request") GetTagList4PageByCondRequest request);

    /**
     * 根据标签名查询标签
     * 
     * @param name 标签名
     * @return 标签实体
     */
    @GetMapping("/tagName/{name}")
    TagBizDto getTagByName(@PathVariable("name") String name);

    /**
     * 新增标签
     * 
     * @param name 标签名
     * @return 标签
     */
    @PostMapping("/tagName/{name}")
    TagBizDto addTag(@PathVariable("name") String name);

    /**
     * 给博文加标签
     * 
     * @param postTagDto 关联
     * @return PostTagDto
     */
    @PostMapping("/post")
    PostTagBizDto linkPostAndTag(@RequestBody PostTagBizDto postTagDto);
}
