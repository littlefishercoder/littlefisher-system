package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.user.converter.SystemParamDtoConverter;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.model.SystemParamDto;
import com.littlefisher.user.model.SystemParamBizDto;

/**
 * Description: 修改系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class UpdateSystemParamCmd extends AbstractCommand<SystemParamBizDto> {

    /**
     * systemParamDto
     */
    private SystemParamBizDto systemParamBizDto;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public UpdateSystemParamCmd setSystemParamDto(SystemParamBizDto systemParamBizDto) {
        this.systemParamBizDto = systemParamBizDto;
        return this;
    }

    @Override
    public SystemParamBizDto execute() {
        SystemParamDto systemParam
            = systemParamDtoDao.updateByPrimaryKey(SystemParamDtoConverter.converterSystemParamDto(systemParamBizDto));
        return SystemParamDtoConverter.converterSystemParamBizDto(systemParam);
    }

}
