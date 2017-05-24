package com.littlefisher.blog.system.cmd;

import com.littlefisher.blog.system.dao.SystemParamDtoMapper;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
 * Description: 根据key查询系统参数
 *  
 * Created on 2017年5月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetSystemParamByKeyCmd extends AbstractCommand<SystemParamDto> {
    
    /**
     * paramKey
     */
    private String paramKey;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param paramKey paramKey 
     */ 
    public GetSystemParamByKeyCmd(String paramKey) {
        super();
        this.paramKey = paramKey;
    }

    @Override
    public SystemParamDto execute() throws BaseAppException {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        return systemParamDtoMapper.selectByParamKey(paramKey);
    }

}
