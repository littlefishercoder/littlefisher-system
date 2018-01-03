package com.littlefisher.blog.cmd.commentary;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CommentaryDtoMapper;
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
public class DeleteCommentaryCmd extends AbstractCommand<Integer> {
    
    /**
     * commentaryId
     */
    private Long commentaryId;

    @Autowired
    private CommentaryDtoMapper commentaryDtoMapper;

    public DeleteCommentaryCmd setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
        return this;
    }

    @Override
    public Integer execute() {
        return commentaryDtoMapper.deleteByPrimaryKey(commentaryId);
    }

}
