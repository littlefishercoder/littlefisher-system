package com.littlefisher.core.biz.framework.dao.user;

import com.littlefisher.core.biz.framework.model.user.UserDto;
import com.littlefisher.core.biz.framework.request.user.GetUserList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Description: user Mapper 接口
 *
 * Created on 2017年12月08日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserDtoMapper extends Mapper<UserDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<UserDto>
     */
    List<UserDto> selectByCond(GetUserList4PagerByCondRequest req);
}