package com.littlefisher.user.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.user.dal.dao.IUserContactStation4SocialDtoDao;
import com.littlefisher.user.dal.example.UserContactStation4SocialDtoExample;
import com.littlefisher.user.dal.mapper.UserContactStation4SocialDtoMapper;
import com.littlefisher.user.dal.model.UserContactStation4SocialDto;

/**
 * Description: UserContactStation4SocialDtoDaoImpl
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserContactStation4SocialDtoDaoImpl
    extends AbstractBaseDaoImpl<UserContactStation4SocialDto, UserContactStation4SocialDtoMapper>
    implements IUserContactStation4SocialDtoDao {

    @Autowired
    private UserContactStation4SocialDtoMapper userContactStation4SocialDtoMapper;

    @Override
    public List<UserContactStation4SocialDto> selectUserContactStation4SocialByStationIdList(List<Long> stationIdList) {
        UserContactStation4SocialDtoExample example = new UserContactStation4SocialDtoExample();
        example.createCriteria().andContactStationIdIn(stationIdList);
        return userContactStation4SocialDtoMapper.selectByExample(example);
    }
}
