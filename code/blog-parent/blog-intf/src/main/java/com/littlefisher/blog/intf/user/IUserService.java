package com.littlefisher.blog.intf.user;

import java.util.List;

import com.littlefisher.blog.model.user.UserDto;

/**
 * Description: IUserService.java
 *
 * Created on 2017年11月21日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return List<UserDto>
     */
    List<UserDto> getAllUser();
}
