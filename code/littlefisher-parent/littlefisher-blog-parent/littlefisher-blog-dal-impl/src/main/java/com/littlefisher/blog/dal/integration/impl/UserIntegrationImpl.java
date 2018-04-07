package com.littlefisher.blog.dal.integration.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.littlefisher.blog.dal.integration.IUserIntegration;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.model.UserContactStation4WebsiteBizDto;
import com.littlefisher.user.service.IUserContactStationService;
import com.littlefisher.user.service.IUserService;

/**
 *
 * @author jinyn22648
 * @version $$Id: BizFrameworkIntegrationImpl.java, v 0.1 2018/3/27 下午7:08 jinyn22648 Exp $$
 */
@Repository
public class UserIntegrationImpl implements IUserIntegration {

    @Reference(interfaceClass = IUserService.class)
    private IUserService userService;

    @Reference(interfaceClass = IUserContactStationService.class)
    private IUserContactStationService userContactStationService;

    @Override
    public List<UserBizDto> getUserByIdList(List<Long> userIdList) {
        return userService.getUserListByIdList(userIdList);
    }

    @Override
    public UserBizDto getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteByUserId(Long userId) {
        return userContactStationService.getUserContactStation4WebsiteByUserId(userId);
    }
}
