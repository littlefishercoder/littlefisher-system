package com.littlefisher.blog.cmd.system;

import com.littlefisher.blog.dao.system.SystemParamDtoMapper;
import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 修改系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UpdateSystemParamCmd extends AbstractCommand<SystemParamDto> {

    /**
     * systemParamDto
     */
    private SystemParamDto systemParamDto;

    /**
     * Description: 构造函数
     *
     * @param systemParamDto systemParamDto
     */
    public UpdateSystemParamCmd(SystemParamDto systemParamDto) {
        super();
        this.systemParamDto = systemParamDto;
    }

    @Override
    public SystemParamDto execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        systemParamDtoMapper.updateByPrimaryKey(systemParamDto);
        return systemParamDto;
    }

}
