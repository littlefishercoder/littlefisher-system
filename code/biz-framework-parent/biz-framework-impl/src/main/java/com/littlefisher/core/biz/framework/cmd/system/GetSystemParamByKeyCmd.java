package com.littlefisher.core.biz.framework.cmd.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.example.SystemParamDtoExample;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.CollectionUtil;

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
public class GetSystemParamByKeyCmd extends AbstractCommand<SystemParamDto> {

    /**
     * paramKey
     */
    private String paramKey;

    @Autowired
    private SystemParamDtoMapper systemParamDtoMapper;

    public GetSystemParamByKeyCmd setParamKey(String paramKey) {
        this.paramKey = paramKey;
        return this;
    }

    @Override
    public SystemParamDto execute() {
        SystemParamDtoExample example = new SystemParamDtoExample();
        example.createCriteria().andParamKeyEqualTo(paramKey);
        List<SystemParamDto> systemParamList = systemParamDtoMapper.selectByExample(example);
        return CollectionUtil.isNotEmpty(systemParamList) ? systemParamList.get(0) : null;
    }

}
