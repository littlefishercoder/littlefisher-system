package com.littlefisher.blog.system.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.system.dao.SystemParamDtoMapper;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
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
public class GetSystemParamList4PagerByCondCmd extends AbstractCommand<List<SystemParamDto>> {

    /**
     * req
     */
    private GetSystemParamList4PagerByCondRequest req;

    /**
     * Description: 构造函数
     *
     * @param req req
     */
    public GetSystemParamList4PagerByCondCmd(GetSystemParamList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<SystemParamDto> execute() {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return systemParamDtoMapper.selectByCond(req);
        //        RowBounds rowBounds = new RowBounds(req.getPageNum() - 1, req.getPageSize());
        //        return systemParamDtoMapper.selectByCond(req, rowBounds);
    }

}
