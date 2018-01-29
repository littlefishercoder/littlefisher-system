package com.littlefisher.core.biz.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.user.AddUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.DeleteUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.GetUserListByCondCmd;
import com.littlefisher.core.biz.framework.cmd.user.GetUserListByIdsCmd;
import com.littlefisher.core.biz.framework.cmd.user.QryAllUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.QryUserByIdCmd;
import com.littlefisher.core.biz.framework.cmd.user.UpdateUserCmd;
import com.littlefisher.core.biz.framework.service.IUserService;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;
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
        return this.execute(getCommand(QryAllUserCmd.class));
    }

    @Override
    public UserDto getUserById(Long userId) {
        return this.execute(getCommand(QryUserByIdCmd.class).setUserId(userId));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return this.execute(getCommand(AddUserCmd.class).setUserDto(userDto));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return this.execute(getCommand(UpdateUserCmd.class).setUserDto(userDto));
    }

    @Override
    public int deleteUser(Long userId) {
        return this.execute(getCommand(DeleteUserCmd.class).setUserId(userId));
    }

    @Override
    public List<UserDto> getUserListByIds(List<Long> userIdList) {
        return this.execute(getCommand(GetUserListByIdsCmd.class).setUserIdList(userIdList));
    }

    @Override
    public List<UserDto> getUserListByCond(GetUserList4PagerByCondRequest req) {
        return this.execute(getCommand(GetUserListByCondCmd.class).setReq(req));
    }

}
