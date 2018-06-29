package com.littlefisher.user.biz.cmd.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.biz.converter.UserContactStation4SocialDtoConverter;
import com.littlefisher.user.biz.model.UserContactStation4SocialBizDto;
import com.littlefisher.user.common.enums.EnumUserContactStationState;
import com.littlefisher.user.common.enums.EnumUserContactStationType;
import com.littlefisher.user.dal.dao.IUserContactStation4SocialDtoDao;
import com.littlefisher.user.dal.dao.IUserContactStationDtoDao;
import com.littlefisher.user.dal.model.UserContactStation4SocialDto;
import com.littlefisher.user.dal.model.UserContactStationDto;

/**
 * Description: GetUserContactStation4SocialByUserIdCmd
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserContactStation4SocialByUserIdCmd extends AbstractCommand<List<UserContactStation4SocialBizDto>> {

    /** 用户id */
    private Long userId;

    @Autowired
    private IUserContactStationDtoDao userContactStationDtoDao;

    @Autowired
    private IUserContactStation4SocialDtoDao userContactStation4SocialDtoDao;

    public GetUserContactStation4SocialByUserIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public List<UserContactStation4SocialBizDto> execute() {
        List<UserContactStationDto> userContactStationList
            = userContactStationDtoDao.selectByRecord(UserContactStationDto.Builder.getInstance().addUserId(userId)
                .addState(EnumUserContactStationState.VALID).addType(EnumUserContactStationType.TELEPHONE).build());
        List<Long> stationIdList
            = Lists.newArrayList(Iterators.transform(userContactStationList.iterator(), UserContactStationDto::getId));
        List<UserContactStation4SocialDto> userContactStation4SocialList
            = userContactStation4SocialDtoDao.selectUserContactStation4SocialByStationIdList(stationIdList);
        return Lists.newArrayList(Iterators.transform(userContactStation4SocialList.iterator(),
            UserContactStation4SocialDtoConverter::convert2UserContactStation4SocialBizDto));
    }
}
