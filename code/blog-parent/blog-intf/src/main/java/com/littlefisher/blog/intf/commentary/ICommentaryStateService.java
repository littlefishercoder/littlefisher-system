package com.littlefisher.blog.intf.commentary;

import java.util.List;

import com.littlefisher.blog.model.commentary.CommentaryStateDto;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ICommentaryStateService {

    /**
     * Description: 查询所有评价类型
     *
     * @return List<CommentaryStateDto>
     */
    List<CommentaryStateDto> getAllCommentaryState();

    /**
     * Description: 新增评价类型
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     */
    CommentaryStateDto addCommentaryState(CommentaryStateDto commentaryStateDto);

    /**
     * Description: 修改评价类型
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     */
    CommentaryStateDto updateCommentaryState(CommentaryStateDto commentaryStateDto);

    /**
     * Description: 删除评价类型
     *
     * @param state state
     * @return int
     */
    int deleteCommentaryState(String state);
}
