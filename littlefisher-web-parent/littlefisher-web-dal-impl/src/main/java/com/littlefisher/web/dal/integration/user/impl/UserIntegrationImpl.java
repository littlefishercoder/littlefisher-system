package com.littlefisher.web.dal.integration.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.request.AddUserRequest;
import com.littlefisher.user.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.request.UpdateUserRequest;
import com.littlefisher.user.service.IUserService;
import com.littlefisher.web.dal.integration.user.IUserIntegration;

/**
 * Description: UserIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserIntegrationImpl implements IUserIntegration {

    @Reference
    private IUserService userService;

    @Override
    public List<UserBizDto> getAllUser() {
        return userService.getAllUser();
    }

    @Override
    public PageInfo<UserBizDto> getUserList4PageByCond(GetUserList4PageByCondRequest req) {
        return userService.getUserList4PageByCond(req);
    }

    @Override
    public UserBizDto getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public UserBizDto addUser(AddUserRequest request) {
        return userService.addUser(request);
    }

    @Override
    public UserBizDto updateUser(UpdateUserRequest request) {
        return userService.updateUser(request);
    }

    @Override
    public int deleteUser(Long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public List<UserBizDto> getUserListByIdList(List<Long> userIdList) {
        return userService.getUserListByIdList(userIdList);
    }
}
