package com.littlefisher.blog.cmd.system;

import com.littlefisher.blog.dao.system.SystemParamDtoMapper;
import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 根据id获取系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetSystemParamByIdCmd extends AbstractCommand<SystemParamDto> {

    /**
     * systemParamId
     */
    private Long systemParamId;

    /**
     * Description: 构造函数
     *
     * @param systemParamId systemParamId
     */
    public GetSystemParamByIdCmd(Long systemParamId) {
        super();
        this.systemParamId = systemParamId;
    }

    @Override
    public SystemParamDto execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        return systemParamDtoMapper.selectByPrimaryKey(systemParamId);
    }

}
