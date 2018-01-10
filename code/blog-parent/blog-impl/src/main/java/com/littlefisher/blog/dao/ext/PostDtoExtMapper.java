package com.littlefisher.blog.dao.ext;

import java.util.List;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.mybatis.mapper.common.CommonMapper;

/**
 * Description: post Mapper 接口
 *
 * Created on 2017年11月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostDtoExtMapper extends PostDtoMapper, CommonMapper<PostDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<PostDto>
     */
    List<PostExtDto> selectByCond(GetPostList4PagerByCondRequest req);
}