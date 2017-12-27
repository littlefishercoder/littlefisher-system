package com.littlefisher.blog.service;

import java.util.List;

import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.blog.model.ext.CommentaryExtDto;
import com.littlefisher.blog.request.GetCommentaryList4PagerByCondRequest;

/**
 * Description: 评价接口
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ICommentaryService {

    /**
     * Description: 根据条件查询评价列表
     *
     * @param req req
     * @return List<CommentaryExtDto>
     */
    List<CommentaryExtDto> getCommentaryList4PagerByCond(GetCommentaryList4PagerByCondRequest req);

    /**
     * Description: 根据主键查询评价
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     */
    CommentaryDto getCommentaryById(Long commentaryId);

    /**
     * Description: 新增评价
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     */
    CommentaryDto addCommentary(CommentaryDto commentaryDto);

    /**
     * Description: 修改评价
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     */
    CommentaryDto updateCommentary(CommentaryDto commentaryDto);

    /**
     * Description: 删除评价
     *
     * @param commentaryId commentaryId
     * @return int
     */
    int deleteCommentary(Long commentaryId);

}
