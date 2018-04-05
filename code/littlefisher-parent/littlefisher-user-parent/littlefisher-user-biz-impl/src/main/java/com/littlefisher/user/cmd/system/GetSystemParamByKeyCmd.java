package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.converter.SystemParamDtoConverter;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.model.SystemParamDto;
import com.littlefisher.user.model.SystemParamBizDto;

/**
 * Description: 根据key查询系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetSystemParamByKeyCmd extends AbstractCommand<SystemParamBizDto> {

    /**
     * paramKey
     */
    private String paramKey;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public GetSystemParamByKeyCmd setParamKey(String paramKey) {
        this.paramKey = paramKey;
        return this;
    }

    @Override
    public SystemParamBizDto execute() {
        SystemParamDto systemParam = systemParamDtoDao.selectByParamKey(paramKey);
        return SystemParamDtoConverter.converterSystemParamBizDto(systemParam);
    }

}
