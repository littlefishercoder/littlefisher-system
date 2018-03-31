package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.user.converter.SystemParamDtoConverter;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.model.SystemParamDto;
import com.littlefisher.user.dal.param.SelectSystemParam4PageByCondParam;
import com.littlefisher.user.model.SystemParamBizDto;
import com.littlefisher.user.request.GetSystemParamList4PageByCondRequest;

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
