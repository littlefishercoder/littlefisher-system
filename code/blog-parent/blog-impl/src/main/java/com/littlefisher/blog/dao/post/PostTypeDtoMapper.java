package com.littlefisher.blog.dao.post;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.post.PostTypeDto;
import com.littlefisher.blog.model.post.PostTypeDtoExample;

/**
 * Description: post_type Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostTypeDtoMapper extends Mapper<PostTypeDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(PostTypeDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<PostTypeDto> List<PostTypeDto><br>
     */
    List<PostTypeDto> selectByExample(PostTypeDtoExample example);
}