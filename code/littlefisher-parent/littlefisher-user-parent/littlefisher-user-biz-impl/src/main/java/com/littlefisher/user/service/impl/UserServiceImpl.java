package com.littlefisher.user.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.user.cmd.user.AddUserCmd;
import com.littlefisher.user.cmd.user.DeleteUserCmd;
import com.littlefisher.user.cmd.user.GetUserListByCondCmd;
import com.littlefisher.user.cmd.user.GetUserListByIdsCmd;
import com.littlefisher.user.cmd.user.QryAllUserCmd;
import com.littlefisher.user.cmd.user.QryUserByIdCmd;
import com.littlefisher.user.cmd.user.UpdateUserCmd;
import com.littlefisher.user.common.enums.EnumUserState;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.utils.DateUtil;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.request.AddUserRequest;
import com.littlefisher.user.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.request.UpdateUserRequest;
import com.littlefisher.user.service.IUserService;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service(interfaceClass = IUserService.class)
public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Override
    public List<UserBizDto> getAllUser() {
        return this.execute(getCommand(QryAllUserCmd.class));
    }

    @Override
    public UserBizDto getUserById(Long userId) {
        return this.execute(getCommand(QryUserByIdCmd.class).setUserId(userId));
    }

    @Override
    public UserBizDto addUser(AddUserRequest request) {
        UserBizDto userDto = UserBizDto.Builder.getInstance().addAccNbr(request.getAccNbr())
            .addPassword(request.getPassword()).addRealName(request.getRealName()).addEnName(request.getEnName())
            .addNickName(request.getNickName()).addUserDesc(request.getUserDesc()).addState(EnumUserState.VALID)
            .addRegDate(DateUtil.getDBDateTime()).build();
        return this.execute(getCommand(AddUserCmd.class).setUserDto(userDto));
    }

    @Override
    public UserBizDto updateUser(UpdateUserRequest request) {
        UserBizDto userDto = UserBizDto.Builder.getInstance(this.getUserById(request.getId()))
            .addAccNbr(request.getAccNbr()).addPassword(request.getPassword()).addRealName(request.getRealName())
            .addNickName(request.getNickName()).addEnName(request.getEnName()).addUserDesc(request.getUserDesc())
            .addState(request.getState()).addLastLoginDate(request.getLastLoginDate()).build();
        return this.execute(getCommand(UpdateUserCmd.class).setUserDto(userDto));
    }

    @Override
    public int deleteUser(Long userId) {
        return this.execute(getCommand(DeleteUserCmd.class).setUserId(userId));
    }

    @Override
    public List<UserBizDto> getUserListByIdList(List<Long> userIdList) {
        return this.execute(getCommand(GetUserListByIdsCmd.class).setUserIdList(userIdList));
    }

    @Override
    public PageInfo<UserBizDto> getUserList4PageByCond(GetUserList4PageByCondRequest req) {
        return this.execute(getCommand(GetUserListByCondCmd.class).setReq(req));
    }

}
