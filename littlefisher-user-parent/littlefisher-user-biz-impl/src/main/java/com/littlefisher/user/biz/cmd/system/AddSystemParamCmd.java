package com.littlefisher.user.biz.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.biz.converter.SystemParamDtoConverter;
import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.model.SystemParamDto;

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
        systemParamDtoDao.insert(systemParam);
        return SystemParamDtoConverter.converterSystemParamBizDto(systemParam);
    }

}
