package com.littlefisher.blog.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.user.cmd.AddUserStateCmd;
import com.littlefisher.blog.user.cmd.DeleteUserStateCmd;
import com.littlefisher.blog.user.cmd.GetAllUserStateCmd;
import com.littlefisher.blog.user.cmd.UpdateUserStateCmd;
import com.littlefisher.blog.user.model.UserStateDto;
import com.littlefisher.blog.user.service.IUserStateService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月25日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class UserStateServiceImpl extends ServiceImpl implements IUserStateService {

    @Override
    public List<UserStateDto> getAllUserState() throws BaseAppException {
        return this.execute(new GetAllUserStateCmd());
    }

    @Override
    public UserStateDto addUserState(UserStateDto userStateDto) throws BaseAppException {
        return this.execute(new AddUserStateCmd(userStateDto));
    }

    @Override
    public UserStateDto updateUserState(UserStateDto userStateDto) throws BaseAppException {
        return this.execute(new UpdateUserStateCmd(userStateDto));
    }

    @Override
    public int deleteUserState(String state) throws BaseAppException {
        return this.execute(new DeleteUserStateCmd(state));
    }

}
