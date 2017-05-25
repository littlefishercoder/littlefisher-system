package com.littlefisher.blog.post.cmd;

import com.littlefisher.blog.post.dao.PostStateDtoMapper;
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
public class DeletePostStateCmd extends AbstractCommand<Integer> {
    
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
    public DeletePostStateCmd(String state) {
        super();
        this.state = state;
    }

    @Override
    public Integer execute() throws BaseAppException {
        PostStateDtoMapper postStateDtoMapper = this.getMapper(PostStateDtoMapper.class);
        return postStateDtoMapper.deleteByPrimaryKey(state);
    }

}
