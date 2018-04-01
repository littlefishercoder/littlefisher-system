package com.littlefisher.web.dal.integration.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.littlefisher.user.model.UserContactStation4EmailBizDto;
import com.littlefisher.user.model.UserContactStation4PhoneBizDto;
import com.littlefisher.user.model.UserContactStation4SocialBizDto;
import com.littlefisher.user.model.UserContactStation4WebsiteBizDto;
import com.littlefisher.user.service.IUserContactStationService;
import com.littlefisher.web.dal.integration.user.IUserContactStationIntegration;

/**
 * Description: UserContactStationIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserContactStationIntegrationImpl implements IUserContactStationIntegration {

    @Reference
    private IUserContactStationService userContactStationService;

    @Override
    public List<UserContactStation4EmailBizDto> getUserContactStation4EmailByUserId(Long userId) {
        return userContactStationService.getUserContactStation4EmailByUserId(userId);
    }

    @Override
    public List<UserContactStation4PhoneBizDto> getUserContactStation4PhoneByUserId(Long userId) {
        return userContactStationService.getUserContactStation4PhoneByUserId(userId);
    }

    @Override
    public List<UserContactStation4SocialBizDto> getUserContactStation4SocialByUserId(Long userId) {
        return userContactStationService.getUserContactStation4SocialByUserId(userId);
    }

    @Override
    public List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteByUserId(
            Long userId) {
        return userContactStationService.getUserContactStation4WebsiteByUserId(userId);
    }
}
