package com.littlefisher.blog.dao.ext;

import java.util.List;

import com.littlefisher.blog.dao.TagDtoMapper;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;
import com.littlefisher.core.mybatis.mapper.common.CommonMapper;

/**
 * Description: TagDtoExtMapper.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface TagDtoExtMapper extends TagDtoMapper, CommonMapper<TagDto> {

    /**
     * 根据条件查询
     * @param request 条件
     * @return tag列表
     */
    List<TagDto> selectByCond(GetTagList4PagerByCondRequest request);

    /**
     * 查询作者名下所有文章的所有tag
     * @param authorId 作者
     * @return tag列表
     */
    List<TagDto> selectTagListByAuthorId(Long authorId);
}
