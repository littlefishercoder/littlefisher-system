package com.littlefisher.blog.dao.commentary;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.commentary.CommentaryStateDto;
import com.littlefisher.blog.model.commentary.CommentaryStateDtoExample;

/**
 * Description: commentary_state Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommentaryStateDtoMapper extends Mapper<CommentaryStateDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(CommentaryStateDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<CommentaryStateDto> List<CommentaryStateDto><br>
     */
    List<CommentaryStateDto> selectByExample(CommentaryStateDtoExample example);
}