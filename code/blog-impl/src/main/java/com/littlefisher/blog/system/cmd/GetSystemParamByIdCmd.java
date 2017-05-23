package com.littlefisher.blog.system.cmd;

import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
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
     * Description: 
     *
     * @author jinyanan
     *
     * @param systemParamId systemParamId 
     */ 
    public GetSystemParamByIdCmd(Long systemParamId) {
        super();
        this.systemParamId = systemParamId;
    }

    @Override
    public SystemParamDto execute() throws BaseAppException {
        // TODO Auto-generated method stub
        return null;
    }

}
