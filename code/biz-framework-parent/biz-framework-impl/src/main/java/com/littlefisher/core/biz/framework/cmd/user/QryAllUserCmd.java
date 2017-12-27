package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

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
public class QryAllUserCmd extends AbstractCommand<List<UserDto>> {

    @Override
    public List<UserDto> execute() {
        UserDtoMapper userDtoMapper = this.getMapper(UserDtoMapper.class);
        return userDtoMapper.selectAll();
    }

}
