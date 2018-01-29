package com.littlefisher.core.biz.framework.cmd.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.example.SystemParamDtoExample;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.StringUtil;

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
    private SystemParamDtoMapper systemParamDtoMapper;

    public GetSystemParamList4PagerByCondCmd setReq(GetSystemParamList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<SystemParamDto> execute() {
        SystemParamDtoExample example = new SystemParamDtoExample();
        SystemParamDtoExample.Criteria criteria = example.createCriteria();
        if (req.getId() != null) {
            criteria.andIdEqualTo(req.getId());
        }
        if (StringUtil.isNotBlank(req.getParamKey())) {
            criteria.andParamKeyLike(req.getParamKey());
        }
        if (StringUtil.isNotBlank(req.getParamValue())) {
            criteria.andParamValueLike(req.getParamValue());
        }
        if (StringUtil.isNotBlank(req.getDefaultValue())) {
            criteria.andDefaultValueLike(req.getDefaultValue());
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return systemParamDtoMapper.selectByExample(req);
    }

}
