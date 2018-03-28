package com.littlefisher.core.biz.framework.cmd.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.biz.framework.common.enums.EnumUserContactStationState;
import com.littlefisher.biz.framework.common.enums.EnumUserContactStationType;
import com.littlefisher.core.biz.framework.converter.UserContactStation4PhoneDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.IUserContactStation4PhoneDtoDao;
import com.littlefisher.core.biz.framework.dal.dao.IUserContactStationDtoDao;
import com.littlefisher.core.biz.framework.dal.model.UserContactStation4PhoneDto;
import com.littlefisher.core.biz.framework.dal.model.UserContactStationDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4PhoneBizDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description: GetUserContactStation4PhoneByUserIdCmd
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserContactStation4PhoneByUserIdCmd extends AbstractCommand<List<UserContactStation4PhoneBizDto>> {

    /** 用户id */
    private Long userId;

    @Autowired
    private IUserContactStationDtoDao userContactStationDtoDao;

    @Autowired
    private IUserContactStation4PhoneDtoDao userContactStation4PhoneDtoDao;

    public GetUserContactStation4PhoneByUserIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public List<UserContactStation4PhoneBizDto> execute() {
        List<UserContactStationDto> userContactStationList
            = userContactStationDtoDao.selectByRecord(UserContactStationDto.Builder.getInstance().addUserId(userId)
                .addState(EnumUserContactStationState.VALID).addType(EnumUserContactStationType.TELEPHONE).build());
        List<Long> stationIdList
            = Lists.newArrayList(Iterators.transform(userContactStationList.iterator(), UserContactStationDto::getId));
        List<UserContactStation4PhoneDto> userContactStation4PhoneList
            = userContactStation4PhoneDtoDao.selectUserContactStation4PhoneByStationIdList(stationIdList);
        return Lists.newArrayList(Iterators.transform(userContactStation4PhoneList.iterator(),
            UserContactStation4PhoneDtoConverter::convert2UserContactStation4PhoneBizDto));
    }
}
