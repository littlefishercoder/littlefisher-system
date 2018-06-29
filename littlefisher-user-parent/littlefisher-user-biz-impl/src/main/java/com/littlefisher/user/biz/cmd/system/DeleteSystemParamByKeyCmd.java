package com.littlefisher.user.biz.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;

/**
 * Description: 根据key删除系统参数
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class DeleteSystemParamByKeyCmd extends AbstractCommand<Integer> {

    /**
     * paramKey
     */
    private String paramKey;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public DeleteSystemParamByKeyCmd setParamKey(String paramKey) {
        this.paramKey = paramKey;
        return this;
    }

    @Override
    public Integer execute() {
        return systemParamDtoDao.deleteByParamKey(paramKey);
    }

}
