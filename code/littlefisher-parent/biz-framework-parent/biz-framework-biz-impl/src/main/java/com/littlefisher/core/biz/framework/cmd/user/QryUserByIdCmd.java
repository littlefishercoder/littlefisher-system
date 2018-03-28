package com.littlefisher.core.biz.framework.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.converter.UserDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.IUserDtoDao;
import com.littlefisher.core.biz.framework.dal.model.UserDto;
import com.littlefisher.core.biz.framework.model.UserBizDto;
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
