package com.yc.crm.jyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.core.exception.BaseAppException;
import com.yc.crm.jyn.dao.UserDtoMapper;
import com.yc.crm.jyn.dto.UserDto;
import com.yc.crm.jyn.service.IUserService;

/**
 * Description: userService 
 * 
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    /** userDtoMapper */
    @Autowired
    private UserDtoMapper userDtoMapper;

    @Override
    public List<UserDto> selectAllUser() throws BaseAppException {

        return userDtoMapper.getAll();
    }

}
