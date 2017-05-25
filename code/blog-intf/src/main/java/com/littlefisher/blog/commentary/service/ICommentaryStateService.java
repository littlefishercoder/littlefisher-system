package com.littlefisher.blog.commentary.service;

import java.util.List;

import com.littlefisher.blog.commentary.model.CommentaryStateDto;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 查询所有评价类型
     * 
     * @author jinyanan
     *
     * @return List<CommentaryStateDto>
     * @throws BaseAppException <br>
     */
    List<CommentaryStateDto> getAllCommentaryState() throws BaseAppException;

    /**
     * 
     * Description: 新增评价类型
     * 
     * @author jinyanan
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     * @throws BaseAppException <br>
     */
    CommentaryStateDto addCommentaryState(CommentaryStateDto commentaryStateDto) throws BaseAppException;
    
    /**
     * 
     * Description: 修改评价类型
     * 
     * @author jinyanan
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     * @throws BaseAppException <br>
     */
    CommentaryStateDto updateCommentaryState(CommentaryStateDto commentaryStateDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除评价类型
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteCommentaryState(String state) throws BaseAppException;
}
