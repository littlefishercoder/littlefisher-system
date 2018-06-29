package com.littlefisher.user.biz.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.dal.dao.IUserDtoDao;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class DeleteUserCmd extends AbstractCommand<Integer> {

    /** userId */
    private Long userId;

    @Autowired
    private IUserDtoDao userDtoDao;

    public DeleteUserCmd setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Integer execute() {
        return userDtoDao.deleteByPrimaryKey(userId);
    }

}
