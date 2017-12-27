package com.littlefisher.core.biz.framework.cmd.user;

import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UpdateUserCmd extends AbstractCommand<UserDto> {

    /**
     * userDto
     */
    private UserDto userDto;

    /**
     * Description: 构造函数
     *
     * @param userDto userDto
     */
    public UpdateUserCmd(UserDto userDto) {
        super();
        this.userDto = userDto;
    }

    @Override
    public UserDto execute() {
        UserDtoMapper userDtoMapper = this.getMapper(UserDtoMapper.class);
        userDtoMapper.updateByPrimaryKey(userDto);
        return userDto;
    }

}
