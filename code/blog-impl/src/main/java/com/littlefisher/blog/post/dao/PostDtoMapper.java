package com.littlefisher.blog.post.dao;

import java.util.List;

import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;


/**
 *
 * Description: post Mapper 接口
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostDtoMapper extends Mapper<PostDto> {

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<PostDto>
     */
    List<PostDto> selectByCond(GetPostList4PagerByCondRequest req);
}