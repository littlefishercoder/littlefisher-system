package com.littlefisher.blog.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.user.cmd.AddUserCmd;
import com.littlefisher.blog.user.cmd.DeleteUserCmd;
import com.littlefisher.blog.user.cmd.QryAllUserCmd;
import com.littlefisher.blog.user.cmd.QryUserByIdCmd;
import com.littlefisher.blog.user.cmd.UpdateUserCmd;
import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.service.IUserService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
@Service("user.UserService")
public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Override
    public List<UserDto> getAllUser() throws BaseAppException {
        return this.execute(new QryAllUserCmd());
    }

    @Override
    public UserDto getUserById(Long userId) throws BaseAppException {
        return this.execute(new QryUserByIdCmd(userId));
    }

    @Override
    public UserDto addUser(UserDto userDto) throws BaseAppException {
        return this.execute(new AddUserCmd(userDto));
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws BaseAppException {
        return this.execute(new UpdateUserCmd(userDto));
    }

    @Override
    public int deleteUser(Long userId) throws BaseAppException {
        return this.execute(new DeleteUserCmd(userId));
    }

}
