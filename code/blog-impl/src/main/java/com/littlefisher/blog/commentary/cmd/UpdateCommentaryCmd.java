package com.littlefisher.blog.commentary.cmd;

import com.littlefisher.blog.commentary.dao.CommentaryDtoMapper;
import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.core.exception.BaseAppException;
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
public class UpdateCommentaryCmd extends AbstractCommand<CommentaryDto> {
    
    /**
     * commentaryDto
     */
    private CommentaryDto commentaryDto;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param commentaryDto commentaryDto  
     */ 
    public UpdateCommentaryCmd(CommentaryDto commentaryDto) {
        super();
        this.commentaryDto = commentaryDto;
    }

    @Override
    public CommentaryDto execute() throws BaseAppException {
        CommentaryDtoMapper commentaryDtoMapper = this.getMapper(CommentaryDtoMapper.class);
        commentaryDtoMapper.updateByPrimaryKey(commentaryDto);
        return commentaryDto;
    }

}
