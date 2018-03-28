package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.converter.SystemParamDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.ISystemParamDtoDao;
import com.littlefisher.core.biz.framework.dal.model.SystemParamDto;
import com.littlefisher.core.biz.framework.model.SystemParamBizDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
