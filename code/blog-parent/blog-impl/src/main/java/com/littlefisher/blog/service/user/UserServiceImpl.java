package com.littlefisher.blog.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.user.QryAllUserCmd;
import com.littlefisher.blog.intf.user.IUserService;
import com.littlefisher.blog.model.user.UserDto;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: UserServiceImpl.java
 *
 * Created on 2017年11月21日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Override
    public List<UserDto> getAllUser() {
        return this.execute(new QryAllUserCmd());
    }
}
