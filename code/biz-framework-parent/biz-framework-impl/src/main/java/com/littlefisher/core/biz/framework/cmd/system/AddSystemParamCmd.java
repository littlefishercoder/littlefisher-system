package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description: 新增系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddSystemParamCmd extends AbstractCommand<SystemParamDto> {

    /**
     * systemParamDto
     */
    private SystemParamDto systemParamDto;

    @Autowired
    private SystemParamDtoMapper systemParamDtoMapper;

    public AddSystemParamCmd setSystemParamDto(SystemParamDto systemParamDto) {
        this.systemParamDto = systemParamDto;
        return this;
    }

    @Override
    public SystemParamDto execute() {
        systemParamDtoMapper.insert(systemParamDto);
        return systemParamDto;
    }

}
