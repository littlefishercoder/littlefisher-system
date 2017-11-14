package com.littlefisher.blog.system.cmd;

import com.littlefisher.blog.system.dao.SystemParamDtoMapper;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 新增系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AddSystemParamCmd extends AbstractCommand<SystemParamDto> {

    /**
     * systemParamDto
     */
    private SystemParamDto systemParamDto;

    /**
     * Description: 构造函数
     *
     * @param systemParamDto systemParamDto
     */
    public AddSystemParamCmd(SystemParamDto systemParamDto) {
        super();
        this.systemParamDto = systemParamDto;
    }

    @Override
    public SystemParamDto execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        systemParamDtoMapper.insert(systemParamDto);
        return systemParamDto;
    }

}
