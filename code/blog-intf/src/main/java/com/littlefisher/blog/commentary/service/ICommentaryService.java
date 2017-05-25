package com.littlefisher.blog.commentary.service;

import java.util.List;

import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.blog.commentary.model.CommentaryStateDto;
import com.littlefisher.blog.commentary.model.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 根据条件查询评价列表
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<CommentaryDto>
     * @throws BaseAppException <br>
     */
    List<CommentaryDto> getCommentaryList4PagerByCond(GetCommentaryList4PagerByCondRequest req) throws BaseAppException;

    /**
     * 
     * Description: 根据主键查询评价
     * 
     * @author jinyanan
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    CommentaryDto getCommentaryById(Long commentaryId) throws BaseAppException;
    
    /**
     * 
     * Description: 新增评价
     * 
     * @author jinyanan
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    CommentaryDto addCommentary(CommentaryDto commentaryDto) throws BaseAppException;
    
    /**
     * 
     * Description: 修改评价
     * 
     * @author jinyanan
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    CommentaryDto updateCommentary(CommentaryDto commentaryDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除评价
     * 
     * @author jinyanan
     *
     * @param commentaryId commentaryId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteCommentary(Long commentaryId) throws BaseAppException;
    
    /**
     * 
     * Description: 查询所有的评论状态
     * 
     * @author jinyanan
     *
     * @return List<CommentaryStateDto>
     * @throws BaseAppException <br>
     */
    List<CommentaryStateDto> getAllCommentaryState() throws BaseAppException;
}
