package com.littlefisher.blog.cmd.commentary;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CommentaryDtoMapper;
import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

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
@Command
public class GetCommentaryByIdCmd extends AbstractCommand<CommentaryDto> {
    
    /**
     * commentaryId
     */
    private Long commentaryId;

    @Autowired
    private CommentaryDtoMapper commentaryDtoMapper;

    public GetCommentaryByIdCmd setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
        return this;
    }

    @Override
    public CommentaryDto execute() {
        return commentaryDtoMapper.selectByPrimaryKey(commentaryId);
    }

}
