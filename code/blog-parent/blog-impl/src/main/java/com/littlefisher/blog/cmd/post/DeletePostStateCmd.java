package com.littlefisher.blog.cmd.post;

import com.littlefisher.blog.dao.post.PostStateDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
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
     * @param state state
     */
    public DeletePostStateCmd(String state) {
        super();
        this.state = state;
    }

    @Override
    public Integer execute() {
        PostStateDtoMapper postStateDtoMapper = this.getMapper(PostStateDtoMapper.class);
        return postStateDtoMapper.deleteByPrimaryKey(state);
    }

}
