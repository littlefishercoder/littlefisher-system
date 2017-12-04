package com.littlefisher.blog.dao.commentary;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.commentary.CommentaryDto;
import com.littlefisher.blog.request.commentary.GetCommentaryList4PagerByCondRequest;

/**
 * Description: commentary Mapper 接口
 *
 * Created on 2017年11月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommentaryDtoMapper extends Mapper<CommentaryDto> {

    /**
     * 根据条件查询评价
     *
     * @param req 查询条件
     * @return List<CommentaryDto> List<CommentaryDto><br>
     */
    List<CommentaryDto> selectByCond(GetCommentaryList4PagerByCondRequest req);
}