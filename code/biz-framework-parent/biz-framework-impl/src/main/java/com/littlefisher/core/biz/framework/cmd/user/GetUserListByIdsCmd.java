package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.example.UserDtoExample;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.CollectionUtil;

/**
 * Description: GetUserListByIdsCmd.java
 *
 * Created on 2018年01月12日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserListByIdsCmd extends AbstractCommand<List<UserDto>> {

    /** 用户id列表 */
    private List<Long> userIdList;

    @Autowired
    private UserDtoMapper userDtoMapper;

    public GetUserListByIdsCmd setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
        return this;
    }

    @Override
    public List<UserDto> execute() {
        if (CollectionUtil.isEmpty(userIdList)) {
            return null;
        }
        UserDtoExample example = new UserDtoExample();
        example.createCriteria().andIdIn(userIdList);
        return userDtoMapper.selectByExample(example);
    }
}
