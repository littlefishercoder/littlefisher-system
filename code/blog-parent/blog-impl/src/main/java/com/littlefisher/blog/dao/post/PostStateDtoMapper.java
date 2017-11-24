package com.littlefisher.blog.dao.post;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.post.PostStateDto;
import com.littlefisher.blog.model.post.PostStateDtoExample;

/**
 * Description: post_state Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PostStateDtoMapper extends Mapper<PostStateDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(PostStateDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<PostStateDto> List<PostStateDto><br>
     */
    List<PostStateDto> selectByExample(PostStateDtoExample example);
}