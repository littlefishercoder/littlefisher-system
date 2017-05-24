package com.littlefisher.blog.commentary.dao;

import java.util.List;

import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.blog.commentary.model.request.GetCommentaryList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;


/**
 *
 * Description: commentary Mapper 接口
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommentaryDtoMapper extends Mapper<CommentaryDto> {

    /**
     * 
     * Description: 根据条件查询评价
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<CommentaryDto>
     */
    List<CommentaryDto> selectByCond(GetCommentaryList4PagerByCondRequest req);
}