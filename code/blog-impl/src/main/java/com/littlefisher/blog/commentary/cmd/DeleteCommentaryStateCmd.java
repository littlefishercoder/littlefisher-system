package com.littlefisher.blog.commentary.cmd;

import com.littlefisher.blog.commentary.dao.CommentaryStateDtoMapper;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

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
public class DeleteCommentaryStateCmd extends AbstractCommand<Integer> {
    
    /**
     * state
     */
    private String state;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param state state 
     */ 
    public DeleteCommentaryStateCmd(String state) {
        super();
        this.state = state;
    }

    @Override
    public Integer execute() throws BaseAppException {
        CommentaryStateDtoMapper commentaryStateDtoMapper = this.getMapper(CommentaryStateDtoMapper.class);
        return commentaryStateDtoMapper.deleteByPrimaryKey(state);
    }

}
