package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.core.biz.framework.converter.UserDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.IUserDtoDao;
import com.littlefisher.core.biz.framework.model.UserBizDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
