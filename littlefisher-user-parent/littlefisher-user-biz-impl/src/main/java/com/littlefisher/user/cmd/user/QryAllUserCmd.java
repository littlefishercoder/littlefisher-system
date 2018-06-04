package com.littlefisher.user.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.converter.UserDtoConverter;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.model.UserBizDto;

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
public class QryAllUserCmd extends AbstractCommand<List<UserBizDto>> {

    @Autowired
    private IUserDtoDao userDtoDao;

    @Override
    public List<UserBizDto> execute() {
        return Lists
            .newArrayList(Iterators.transform(userDtoDao.selectAll().iterator(), UserDtoConverter::convert2UserBizDto));
    }

}
