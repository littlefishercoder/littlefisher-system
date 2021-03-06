package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.converter.SystemParamDtoConverter;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.model.SystemParamDto;
import com.littlefisher.user.model.SystemParamBizDto;

/**
 * Description: 根据id获取系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetSystemParamByIdCmd extends AbstractCommand<SystemParamBizDto> {

    /**
     * systemParamId
     */
    private Long systemParamId;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public GetSystemParamByIdCmd setSystemParamId(Long systemParamId) {
        this.systemParamId = systemParamId;
        return this;
    }

    @Override
    public SystemParamBizDto execute() {
        SystemParamDto systemParam = systemParamDtoDao.selectByPrimaryKey(systemParamId);
        return SystemParamDtoConverter.converterSystemParamBizDto(systemParam);
    }

}
