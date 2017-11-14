package com.littlefisher.blog.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.user.cmd.AddUserCmd;
import com.littlefisher.blog.user.cmd.DeleteUserCmd;
import com.littlefisher.blog.user.cmd.GetUserListByCondCmd;
import com.littlefisher.blog.user.cmd.QryAllUserCmd;
import com.littlefisher.blog.user.cmd.QryUserByIdCmd;
import com.littlefisher.blog.user.cmd.UpdateUserCmd;
import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.model.request.GetUserList4PagerByCondRequest;
import com.littlefisher.blog.user.service.IUserService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Override
    public List<UserDto> getAllUser() {
        return this.execute(new QryAllUserCmd());
    }

    @Override
    public UserDto getUserById(Long userId) {
        return this.execute(new QryUserByIdCmd(userId));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return this.execute(new AddUserCmd(userDto));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return this.execute(new UpdateUserCmd(userDto));
    }

    @Override
    public int deleteUser(Long userId) {
        return this.execute(new DeleteUserCmd(userId));
    }

    @Override
    public List<UserDto> getUserListByCond(GetUserList4PagerByCondRequest req) {
        return this.execute(new GetUserListByCondCmd(req));
    }

}
