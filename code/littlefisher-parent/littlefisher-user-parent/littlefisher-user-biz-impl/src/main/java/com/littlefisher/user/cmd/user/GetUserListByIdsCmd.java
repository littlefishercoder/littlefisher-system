package com.littlefisher.user.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.common.utils.CollectionUtil;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.converter.UserDtoConverter;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.dal.model.UserDto;
import com.littlefisher.user.model.UserBizDto;


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
public class GetUserListByIdsCmd extends AbstractCommand<List<UserBizDto>> {

    /** 用户id列表 */
    private List<Long> userIdList;

    @Autowired
    private IUserDtoDao userDtoDao;

    public GetUserListByIdsCmd setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
        return this;
    }

    @Override
    public List<UserBizDto> execute() {
        if (CollectionUtil.isEmpty(userIdList)) {
            return null;
        }
        List<UserDto> userList = userDtoDao.selectByIds(userIdList);
        return Lists.newArrayList(Iterators.transform(userList.iterator(), UserDtoConverter::convert2UserBizDto));
    }
}
