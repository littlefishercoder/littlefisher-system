package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
public class GetSystemParamByIdCmd extends AbstractCommand<SystemParamDto> {

    /**
     * systemParamId
     */
    private Long systemParamId;

    @Autowired
    private SystemParamDtoMapper systemParamDtoMapper;

    public GetSystemParamByIdCmd setSystemParamId(Long systemParamId) {
        this.systemParamId = systemParamId;
        return this;
    }

    @Override
    public SystemParamDto execute() {
        return systemParamDtoMapper.selectByPrimaryKey(systemParamId);
    }

}
