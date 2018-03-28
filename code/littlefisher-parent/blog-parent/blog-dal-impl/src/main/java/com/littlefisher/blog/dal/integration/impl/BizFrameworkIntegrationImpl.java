package com.littlefisher.blog.dal.integration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.integration.IBizFrameworkIntegration;
import com.littlefisher.core.biz.framework.model.UserBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteBizDto;
import com.littlefisher.core.biz.framework.service.IUserContactStationService;
import com.littlefisher.core.biz.framework.service.IUserService;

/**
 *
 * @author jinyn22648
 * @version $$Id: BizFrameworkIntegrationImpl.java, v 0.1 2018/3/27 下午7:08 jinyn22648 Exp $$
 */
@Repository
public class BizFrameworkIntegrationImpl implements IBizFrameworkIntegration {

    @Autowired
    private IUserService userService;

    @Autowired
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
