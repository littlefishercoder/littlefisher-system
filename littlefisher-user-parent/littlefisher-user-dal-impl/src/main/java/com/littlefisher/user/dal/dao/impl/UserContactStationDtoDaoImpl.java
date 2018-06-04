package com.littlefisher.user.dal.dao.impl;

import org.springframework.stereotype.Repository;

import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.user.dal.dao.IUserContactStationDtoDao;
import com.littlefisher.user.dal.mapper.UserContactStationDtoMapper;
import com.littlefisher.user.dal.model.UserContactStationDto;

/**
 * Description: UserContactStationDtoDaoImpl
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class UserContactStationDtoDaoImpl extends AbstractBaseDaoImpl<UserContactStationDto, UserContactStationDtoMapper>
        implements IUserContactStationDtoDao {

}
