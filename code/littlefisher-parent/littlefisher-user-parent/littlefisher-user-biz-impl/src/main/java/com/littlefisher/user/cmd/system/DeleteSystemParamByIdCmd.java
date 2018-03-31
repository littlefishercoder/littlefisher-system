package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class DeleteSystemParamByIdCmd extends AbstractCommand<Integer> {

    /**
     * systemParamId
     */
    private Long systemParamId;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public DeleteSystemParamByIdCmd setSystemParamId(Long systemParamId) {
        this.systemParamId = systemParamId;
        return this;
    }

    @Override
    public Integer execute() {
        return systemParamDtoDao.deleteByPrimaryKey(systemParamId);
    }

}
