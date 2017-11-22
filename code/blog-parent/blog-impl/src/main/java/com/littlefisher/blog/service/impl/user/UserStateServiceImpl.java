package com.littlefisher.blog.service.impl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.user.AddUserStateCmd;
import com.littlefisher.blog.cmd.user.DeleteUserStateCmd;
import com.littlefisher.blog.cmd.user.GetAllUserStateCmd;
import com.littlefisher.blog.cmd.user.UpdateUserStateCmd;
import com.littlefisher.blog.intf.user.IUserStateService;
import com.littlefisher.blog.model.user.UserStateDto;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
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
    public List<UserStateDto> getAllUserState() {
        return this.execute(new GetAllUserStateCmd());
    }

    @Override
    public UserStateDto addUserState(UserStateDto userStateDto) {
        return this.execute(new AddUserStateCmd(userStateDto));
    }

    @Override
    public UserStateDto updateUserState(UserStateDto userStateDto) {
        return this.execute(new UpdateUserStateCmd(userStateDto));
    }

    @Override
    public int deleteUserState(String state) {
        return this.execute(new DeleteUserStateCmd(state));
    }

}
