package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.converter.SystemParamDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.ISystemParamDtoDao;
import com.littlefisher.core.biz.framework.dal.model.SystemParamDto;
import com.littlefisher.core.biz.framework.model.SystemParamBizDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
public class AddSystemParamCmd extends AbstractCommand<SystemParamBizDto> {

    /**
     * systemParamDto
     */
    private SystemParamBizDto systemParamBizDto;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public AddSystemParamCmd setSystemParamDto(SystemParamBizDto systemParamBizDto) {
        this.systemParamBizDto = systemParamBizDto;
        return this;
    }

    @Override
    public SystemParamBizDto execute() {
        SystemParamDto systemParam = SystemParamDtoConverter.converterSystemParamDto(systemParamBizDto);
        return SystemParamDtoConverter.converterSystemParamBizDto(systemParam);
    }

}
