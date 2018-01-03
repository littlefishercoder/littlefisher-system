package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

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
    private SystemParamDtoMapper systemParamDtoMapper;

    public DeleteSystemParamByIdCmd setSystemParamId(Long systemParamId) {
        this.systemParamId = systemParamId;
        return this;
    }

    @Override
    public Integer execute() {
        return systemParamDtoMapper.deleteByPrimaryKey(systemParamId);
    }

}
