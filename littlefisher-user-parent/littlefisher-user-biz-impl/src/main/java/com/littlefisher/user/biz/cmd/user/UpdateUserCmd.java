package com.littlefisher.user.biz.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.biz.converter.UserDtoConverter;
import com.littlefisher.user.biz.model.UserBizDto;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.dal.model.UserDto;

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
public class UpdateUserCmd extends AbstractCommand<UserBizDto> {

    /**
     * userDto
     */
    private UserBizDto userBizDto;

    @Autowired
    private IUserDtoDao userDtoDao;

    public UpdateUserCmd setUserDto(UserBizDto userBizDto) {
        this.userBizDto = userBizDto;
        return this;
    }

    @Override
    public UserBizDto execute() {
        UserDto userDto = userDtoDao.updateByPrimaryKey(UserDtoConverter.convert2UserDto(userBizDto));
        return UserDtoConverter.convert2UserBizDto(userDto);
    }

}
