package com.littlefisher.user.cmd.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.user.common.enums.EnumUserContactStationState;
import com.littlefisher.user.common.enums.EnumUserContactStationType;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.user.converter.UserContactStation4WebsiteDtoConverter;
import com.littlefisher.user.dal.dao.IUserContactStation4WebsiteDtoDao;
import com.littlefisher.user.dal.dao.IUserContactStationDtoDao;
import com.littlefisher.user.dal.model.UserContactStation4WebsiteDto;
import com.littlefisher.user.dal.model.UserContactStationDto;
import com.littlefisher.user.model.UserContactStation4WebsiteBizDto;

/**
 * Description: GetUserContactStation4WebsiteByUserIdCmd
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserContactStation4WebsiteByUserIdCmd extends AbstractCommand<List<UserContactStation4WebsiteBizDto>> {

    /** 用户id */
    private Long userId;

    @Autowired
    private IUserContactStationDtoDao userContactStationDtoDao;

    @Autowired
    private IUserContactStation4WebsiteDtoDao userContactStation4WebsiteDtoDao;

    public GetUserContactStation4WebsiteByUserIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public List<UserContactStation4WebsiteBizDto> execute() {
        List<UserContactStationDto> userContactStationList
            = userContactStationDtoDao.selectByRecord(UserContactStationDto.Builder.getInstance().addUserId(userId)
                .addState(EnumUserContactStationState.VALID).addType(EnumUserContactStationType.TELEPHONE).build());
        List<Long> stationIdList
            = Lists.newArrayList(Iterators.transform(userContactStationList.iterator(), UserContactStationDto::getId));
        List<UserContactStation4WebsiteDto> userContactStation4WebsiteList
            = userContactStation4WebsiteDtoDao.selectUserContactStation4WebsiteByStationIdList(stationIdList);
        return Lists.newArrayList(Iterators.transform(userContactStation4WebsiteList.iterator(),
            UserContactStation4WebsiteDtoConverter::convert2UserContactStation4WebsiteBizDto));
    }
}
