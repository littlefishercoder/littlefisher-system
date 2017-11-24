package com.littlefisher.blog.dao.commentary;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.commentary.CommentaryDto;
import com.littlefisher.blog.model.commentary.CommentaryDtoExample;

/**
 * Description: commentary Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommentaryDtoMapper extends Mapper<CommentaryDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(CommentaryDtoExample example);

    /**
     * Description: selectByExampleWithBLOBs<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<CommentaryDto> List<CommentaryDto><br>
     */
    List<CommentaryDto> selectByExampleWithBLOBs(CommentaryDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<CommentaryDto> List<CommentaryDto><br>
     */
    List<CommentaryDto> selectByExample(CommentaryDtoExample example);
}