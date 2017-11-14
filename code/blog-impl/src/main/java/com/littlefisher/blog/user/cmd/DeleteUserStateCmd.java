package com.littlefisher.blog.user.cmd;

import com.littlefisher.blog.user.dao.UserStateDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 删除用户状态
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DeleteUserStateCmd extends AbstractCommand<Integer> {

    /**
     * state
     */
    private String state;

    /**
     * Description: 构造函数
     *
     * @param state state
     */
    public DeleteUserStateCmd(String state) {
        super();
        this.state = state;
    }

    @Override
    public Integer execute() {
        UserStateDtoMapper userStateDtoMapper = this.getMapper(UserStateDtoMapper.class);
        return userStateDtoMapper.deleteByPrimaryKey(state);
    }

}
