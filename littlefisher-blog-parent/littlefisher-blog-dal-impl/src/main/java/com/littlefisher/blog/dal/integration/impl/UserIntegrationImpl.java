package com.littlefisher.blog.dal.integration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.integration.IUserIntegration;
import com.littlefisher.user.biz.model.UserBizDto;
import com.littlefisher.user.biz.model.UserContactStation4WebsiteBizDto;
import com.littlefisher.user.biz.service.IUserContactStationService;
import com.littlefisher.user.biz.service.IUserService;

/**
 *
 * @author jinyn22648
 * @version $$Id: BizFrameworkIntegrationImpl.java, v 0.1 2018/3/27 下午7:08 jinyn22648 Exp $$
 */
@Repository
public class UserIntegrationImpl implements IUserIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private IUserService userService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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
