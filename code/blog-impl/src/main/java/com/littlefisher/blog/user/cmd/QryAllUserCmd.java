package com.littlefisher.blog.user.cmd;

import java.util.List;

import com.littlefisher.blog.user.dao.UserDtoMapper;
import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
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
    public List<UserDto> execute() throws BaseAppException {
        UserDtoMapper userDtoMapper = this.getMapper(UserDtoMapper.class);
        return userDtoMapper.selectAll();
    }

}
