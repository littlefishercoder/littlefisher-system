package com.littlefisher.core.biz.framework.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class QryUserByIdCmd extends AbstractCommand<UserDto> {

    /**
     * userId
     */
    private Long userId;

    @Autowired
    private UserDtoMapper userDtoMapper;

    public QryUserByIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public UserDto execute() {
        return userDtoMapper.selectByPrimaryKey(userId);
    }

}
