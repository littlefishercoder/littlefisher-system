package com.littlefisher.blog.cmd.system;

import com.littlefisher.blog.dao.system.SystemParamDtoMapper;
import com.littlefisher.blog.model.system.SystemParamDtoExample;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: 根据key删除系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DeleteSystemParamByKeyCmd extends AbstractCommand<Integer> {

    /**
     * paramKey
     */
    private String paramKey;

    /**
     * Description: 构造函数
     *
     * @param paramKey paramKey
     */
    public DeleteSystemParamByKeyCmd(String paramKey) {
        super();
        this.paramKey = paramKey;
    }

    @Override
    public Integer execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        SystemParamDtoExample example = new SystemParamDtoExample();
        example.createCriteria().andParamKeyEqualTo(paramKey);
        return systemParamDtoMapper.deleteByExample(example);
    }

}
