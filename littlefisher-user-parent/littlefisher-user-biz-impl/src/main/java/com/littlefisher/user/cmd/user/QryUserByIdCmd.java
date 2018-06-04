package com.littlefisher.user.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.converter.UserDtoConverter;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.dal.model.UserDto;
import com.littlefisher.user.model.UserBizDto;

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
public class QryUserByIdCmd extends AbstractCommand<UserBizDto> {

    /**
     * userId
     */
    private Long userId;

    @Autowired
    private IUserDtoDao userDtoDao;

    public QryUserByIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public UserBizDto execute() {
        UserDto userDto = userDtoDao.selectByPrimaryKey(userId);
        return UserDtoConverter.convert2UserBizDto(userDto);
    }

}
