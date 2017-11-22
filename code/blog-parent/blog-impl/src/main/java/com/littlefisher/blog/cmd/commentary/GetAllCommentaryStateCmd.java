package com.littlefisher.blog.cmd.commentary;

import java.util.List;

import com.littlefisher.blog.dao.commentary.CommentaryStateDtoMapper;
import com.littlefisher.blog.model.commentary.CommentaryStateDto;
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
public class GetAllCommentaryStateCmd extends AbstractCommand<List<CommentaryStateDto>> {

    @Override
    public List<CommentaryStateDto> execute() {
        CommentaryStateDtoMapper commentaryStateDtoMapper = this.getMapper(CommentaryStateDtoMapper.class);
        return commentaryStateDtoMapper.selectAll();
    }

}
