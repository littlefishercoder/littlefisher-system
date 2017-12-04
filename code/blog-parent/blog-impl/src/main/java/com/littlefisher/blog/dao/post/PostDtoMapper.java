package com.littlefisher.blog.dao.post;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.post.PostDto;
import com.littlefisher.blog.request.post.GetPostList4PagerByCondRequest;

/**
 * Description: post Mapper 接口
 *
 * Created on 2017年11月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostDtoMapper extends Mapper<PostDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<PostDto>
     */
    List<PostDto> selectByCond(GetPostList4PagerByCondRequest req);
}