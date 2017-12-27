package com.littlefisher.core.biz.framework.cmd.system;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DeleteSystemParamByIdCmd extends AbstractCommand<Integer> {

    /**
     * systemParamId
     */
    private Long systemParamId;

    /**
     * Description: 构造函数
     *
     * @param systemParamId systemParamId
     */
    public DeleteSystemParamByIdCmd(Long systemParamId) {
        super();
        this.systemParamId = systemParamId;
    }

    @Override
    public Integer execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        return systemParamDtoMapper.deleteByPrimaryKey(systemParamId);
    }

}
