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
public class UpdateCommentaryCmd extends AbstractCommand<CommentaryDto> {
    
    /**
     * commentaryDto
     */
    private CommentaryDto commentaryDto;

    @Autowired
    private CommentaryDtoMapper commentaryDtoMapper;

    public UpdateCommentaryCmd setCommentaryDto(CommentaryDto commentaryDto) {
        this.commentaryDto = commentaryDto;
        return this;
    }

    @Override
    public CommentaryDto execute() {
        commentaryDtoMapper.updateByPrimaryKey(commentaryDto);
        return commentaryDto;
    }

}
