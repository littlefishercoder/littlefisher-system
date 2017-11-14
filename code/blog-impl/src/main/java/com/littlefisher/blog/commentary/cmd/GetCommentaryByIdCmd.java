package com.littlefisher.blog.commentary.cmd;

import com.littlefisher.blog.commentary.dao.CommentaryDtoMapper;
import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月24日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetCommentaryByIdCmd extends AbstractCommand<CommentaryDto> {
    
    /**
     * commentaryId
     */
    private Long commentaryId;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param commentaryId commentaryId 
     */ 
    public GetCommentaryByIdCmd(Long commentaryId) {
        super();
        this.commentaryId = commentaryId;
    }

    @Override
    public CommentaryDto execute() {
        CommentaryDtoMapper commentaryDtoMapper = this.getMapper(CommentaryDtoMapper.class);
        return commentaryDtoMapper.selectByPrimaryKey(commentaryId);
    }

}
