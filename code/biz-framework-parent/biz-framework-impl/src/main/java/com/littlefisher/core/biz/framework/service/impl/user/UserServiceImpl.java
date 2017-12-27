package com.littlefisher.core.biz.framework.service.impl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.user.AddUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.DeleteUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.GetUserListByCondCmd;
import com.littlefisher.core.biz.framework.cmd.user.QryAllUserCmd;
import com.littlefisher.core.biz.framework.cmd.user.QryUserByIdCmd;
import com.littlefisher.core.biz.framework.cmd.user.UpdateUserCmd;
import com.littlefisher.core.biz.framework.intf.user.IUserService;
import com.littlefisher.core.biz.framework.model.user.UserDto;
import com.littlefisher.core.biz.framework.request.user.GetUserList4PagerByCondRequest;
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
