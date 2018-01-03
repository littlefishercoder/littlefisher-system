package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

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
public class QryAllUserCmd extends AbstractCommand<List<UserDto>> {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Override
    public List<UserDto> execute() {
        return userDtoMapper.selectAll();
    }

}
