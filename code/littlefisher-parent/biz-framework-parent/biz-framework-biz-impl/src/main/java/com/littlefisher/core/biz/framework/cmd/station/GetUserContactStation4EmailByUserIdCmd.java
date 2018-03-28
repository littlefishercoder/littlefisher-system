package com.littlefisher.core.biz.framework.cmd.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.biz.framework.common.enums.EnumUserContactStationState;
import com.littlefisher.biz.framework.common.enums.EnumUserContactStationType;
import com.littlefisher.core.biz.framework.converter.UserContactStation4EmailDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.IUserContactStation4EmailDtoDao;
import com.littlefisher.core.biz.framework.dal.dao.IUserContactStationDtoDao;
import com.littlefisher.core.biz.framework.dal.model.UserContactStation4EmailDto;
import com.littlefisher.core.biz.framework.dal.model.UserContactStationDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4EmailBizDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description: GetUserContactStation4EmailByUserIdCmd
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserContactStation4EmailByUserIdCmd extends AbstractCommand<List<UserContactStation4EmailBizDto>> {

    /** 用户id */
    private Long userId;

    @Autowired
    private IUserContactStation4EmailDtoDao userContactStation4EmailDtoDao;

    @Autowired
    private IUserContactStationDtoDao userContactStationDtoDao;

    public GetUserContactStation4EmailByUserIdCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public List<UserContactStation4EmailBizDto> execute() {
        List<UserContactStationDto> userContactStationList
                = userContactStationDtoDao.selectByRecord(UserContactStationDto.Builder.getInstance().addUserId(userId)
                .addState(EnumUserContactStationState.VALID).addType(EnumUserContactStationType.EMAIL).build());
        List<Long> stationIdList
            = Lists.newArrayList(Iterators.transform(userContactStationList.iterator(), UserContactStationDto::getId));
        List<UserContactStation4EmailDto> userContactStation4EmailList
            = userContactStation4EmailDtoDao.selectUserContactStation4EmailByStationIdList(stationIdList);
        return Lists.newArrayList(Iterators.transform(userContactStation4EmailList.iterator(),
            UserContactStation4EmailDtoConverter::convert2UserContactStation4EmailBizDto));
    }
}
