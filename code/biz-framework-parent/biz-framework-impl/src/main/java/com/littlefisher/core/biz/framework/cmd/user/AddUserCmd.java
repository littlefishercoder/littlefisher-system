package com.littlefisher.core.biz.framework.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

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
public class AddUserCmd extends AbstractCommand<UserDto> {

    /**
     * userDto
     */
    private UserDto userDto;

    @Autowired
    private UserDtoMapper userDtoMapper;

    public AddUserCmd setUserDto(UserDto userDto) {
        this.userDto = userDto;
        return this;
    }

    @Override
    public UserDto execute() {
        userDtoMapper.insert(userDto);
        return userDto;
    }

}
