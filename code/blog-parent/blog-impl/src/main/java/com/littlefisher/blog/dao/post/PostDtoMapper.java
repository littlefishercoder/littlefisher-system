package com.littlefisher.blog.dao.post;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.post.PostDto;
import com.littlefisher.blog.model.post.PostDtoExample;

/**
 * Description: post Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostDtoMapper extends Mapper<PostDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(PostDtoExample example);

    /**
     * Description: selectByExampleWithBLOBs<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<PostDto> List<PostDto><br>
     */
    List<PostDto> selectByExampleWithBLOBs(PostDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<PostDto> List<PostDto><br>
     */
    List<PostDto> selectByExample(PostDtoExample example);
}