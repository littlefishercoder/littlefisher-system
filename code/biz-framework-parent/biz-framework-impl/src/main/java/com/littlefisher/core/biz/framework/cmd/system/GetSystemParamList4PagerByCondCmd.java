package com.littlefisher.core.biz.framework.cmd.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.dao.ext.SystemParamDtoExtMapper;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetSystemParamList4PagerByCondCmd extends AbstractCommand<List<SystemParamDto>> {

    /**
     * req
     */
    private GetSystemParamList4PagerByCondRequest req;

    @Autowired
    private SystemParamDtoExtMapper systemParamDtoMapper;

    public GetSystemParamList4PagerByCondCmd setReq(GetSystemParamList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<SystemParamDto> execute() {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return systemParamDtoMapper.selectByCond(req);
        //        RowBounds rowBounds = new RowBounds(req.getPageNum() - 1, req.getPageSize());
        //        return systemParamDtoMapper.selectByCond(req, rowBounds);
    }

}
