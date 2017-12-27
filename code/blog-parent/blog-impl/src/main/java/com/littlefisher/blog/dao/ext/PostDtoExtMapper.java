package com.littlefisher.blog.dao.ext;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;

/**
 * Description: post Mapper 接口
 *
 * Created on 2017年11月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostDtoExtMapper extends PostDtoMapper, Mapper<PostDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<PostDto>
     */
    List<PostExtDto> selectByCond(GetPostList4PagerByCondRequest req);
}