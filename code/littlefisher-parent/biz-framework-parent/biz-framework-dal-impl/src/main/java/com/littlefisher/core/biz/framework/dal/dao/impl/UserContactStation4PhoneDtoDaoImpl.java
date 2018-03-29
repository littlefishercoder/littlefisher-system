package com.littlefisher.core.biz.framework.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.core.biz.framework.dal.dao.IUserContactStation4PhoneDtoDao;
import com.littlefisher.core.biz.framework.dal.example.UserContactStation4PhoneDtoExample;
import com.littlefisher.core.biz.framework.dal.mapper.UserContactStation4PhoneDtoMapper;
import com.littlefisher.core.biz.framework.dal.model.UserContactStation4PhoneDto;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;

/**
 * Description: UserContactStation4PhoneDtoDaoImpl
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserContactStation4PhoneDtoDaoImpl
    extends AbstractBaseDaoImpl<UserContactStation4PhoneDto, UserContactStation4PhoneDtoMapper>
    implements IUserContactStation4PhoneDtoDao {

    @Autowired
    private UserContactStation4PhoneDtoMapper userContactStation4PhoneDtoMapper;

    @Override
    public List<UserContactStation4PhoneDto> selectUserContactStation4PhoneByStationIdList(List<Long> stationIdList) {
        UserContactStation4PhoneDtoExample example = new UserContactStation4PhoneDtoExample();
        example.createCriteria().andContactStationIdIn(stationIdList);
        return userContactStation4PhoneDtoMapper.selectByExample(example);
    }
}
