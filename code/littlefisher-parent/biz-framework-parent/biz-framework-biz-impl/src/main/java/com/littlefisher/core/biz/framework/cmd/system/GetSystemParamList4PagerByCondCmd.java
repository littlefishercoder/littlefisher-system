package com.littlefisher.core.biz.framework.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.biz.framework.converter.SystemParamDtoConverter;
import com.littlefisher.core.biz.framework.dal.dao.ISystemParamDtoDao;
import com.littlefisher.core.biz.framework.dal.model.SystemParamDto;
import com.littlefisher.core.biz.framework.dal.param.SelectSystemParam4PageByCondParam;
import com.littlefisher.core.biz.framework.model.SystemParamBizDto;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.stereotype.annotations.Command;

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
public class GetSystemParamList4PagerByCondCmd extends AbstractCommand<PageInfo<SystemParamBizDto>> {

    /**
     * req
     */
    private GetSystemParamList4PageByCondRequest req;

    @Autowired
    private ISystemParamDtoDao systemParamDtoDao;

    public GetSystemParamList4PagerByCondCmd setReq(GetSystemParamList4PageByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public PageInfo<SystemParamBizDto> execute() {
        PageInfo<SystemParamDto> pageInfo = systemParamDtoDao.selectSystemParam4PageByCond(
            SelectSystemParam4PageByCondParam.Builder.getInstance().addId(req.getId()).addParamKey(req.getParamKey())
                .addParamValue(req.getParamValue()).addDefaultValue(req.getDefaultValue()).build(),
            PageParam.Builder.getInstance().addPageNum(req.getPageNum()).addPageSize(req.getPageSize()).build());
        return new PageInfo<>(pageInfo, SystemParamDtoConverter::converterSystemParamBizDto);
    }

}
