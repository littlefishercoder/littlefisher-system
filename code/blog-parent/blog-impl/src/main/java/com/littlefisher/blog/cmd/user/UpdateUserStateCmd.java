package com.littlefisher.blog.cmd.user;

import com.littlefisher.blog.dao.user.UserStateDtoMapper;
import com.littlefisher.blog.model.user.UserStateDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UpdateUserStateCmd extends AbstractCommand<UserStateDto> {

    /**
     * userStateDto
     */
    private UserStateDto userStateDto;

    /**
     * Description: 构造函数
     *
     * @param userStateDto userStateDto
     */
    public UpdateUserStateCmd(UserStateDto userStateDto) {
        super();
        this.userStateDto = userStateDto;
    }

    @Override
    public UserStateDto execute() {
        UserStateDtoMapper userStateDtoMapper = this.getMapper(UserStateDtoMapper.class);
        userStateDtoMapper.updateByPrimaryKey(userStateDto);
        return userStateDto;
    }

}
