package com.littlefisher.user.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.user.dal.dao.IUserContactStation4EmailDtoDao;
import com.littlefisher.user.dal.example.UserContactStation4EmailDtoExample;
import com.littlefisher.user.dal.mapper.UserContactStation4EmailDtoMapper;
import com.littlefisher.user.dal.model.UserContactStation4EmailDto;

/**
 * Description: UserContactStation4EmailDtoDaoImpl
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserContactStation4EmailDtoDaoImpl
    extends AbstractBaseDaoImpl<UserContactStation4EmailDto, UserContactStation4EmailDtoMapper>
    implements IUserContactStation4EmailDtoDao {

    @Autowired
    private UserContactStation4EmailDtoMapper userContactStation4EmailDtoMapper;

    @Override
    public List<UserContactStation4EmailDto> selectUserContactStation4EmailByStationIdList(List<Long> stationIdList) {
        UserContactStation4EmailDtoExample example = new UserContactStation4EmailDtoExample();
        example.createCriteria().andContactStationIdIn(stationIdList);
        return userContactStation4EmailDtoMapper.selectByExample(example);
    }
}
