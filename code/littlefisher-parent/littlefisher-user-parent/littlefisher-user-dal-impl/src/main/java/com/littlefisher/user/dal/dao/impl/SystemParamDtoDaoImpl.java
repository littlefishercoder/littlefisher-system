package com.littlefisher.user.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.common.utils.StringUtil;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.user.dal.dao.ISystemParamDtoDao;
import com.littlefisher.user.dal.example.SystemParamDtoExample;
import com.littlefisher.user.dal.mapper.SystemParamDtoMapper;
import com.littlefisher.user.dal.model.SystemParamDto;
import com.littlefisher.user.dal.param.SelectSystemParam4PageByCondParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: SystemParamDtoDaoImpl.java, v 0.1 2018/3/23 下午4:46 jinyn22648 Exp $$
 */
@Repository
public class SystemParamDtoDaoImpl extends AbstractBaseDaoImpl<SystemParamDto, SystemParamDtoMapper>
        implements
        ISystemParamDtoDao {

    @Autowired
    private SystemParamDtoMapper systemParamDtoMapper;

    @Override
    public int deleteByParamKey(String systemParamKey) {
        SystemParamDtoExample example = new SystemParamDtoExample();
        example.createCriteria().andParamKeyEqualTo(systemParamKey);
        return systemParamDtoMapper.deleteByExample(example);
    }

    @Override
    public SystemParamDto selectByParamKey(String systemParamKey) {
        SystemParamDtoExample example = new SystemParamDtoExample();
        example.createCriteria().andParamKeyEqualTo(systemParamKey);
        return systemParamDtoMapper.selectOneByExample(example);
    }

    @Override
    public PageInfo<SystemParamDto> selectSystemParam4PageByCond(SelectSystemParam4PageByCondParam param, PageParam pageParam) {
        SystemParamDtoExample example = new SystemParamDtoExample();
        SystemParamDtoExample.Criteria criteria = example.createCriteria();
        if (param.getId() != null) {
            criteria.andIdEqualTo(param.getId());
        }
        if (StringUtil.isNotBlank(param.getParamKey())) {
            criteria.andParamKeyLike(param.getParamKey());
        }
        if (StringUtil.isNotBlank(param.getParamValue())) {
            criteria.andParamValueLike(param.getParamValue());
        }
        if (StringUtil.isNotBlank(param.getDefaultValue())) {
            criteria.andDefaultValueLike(param.getDefaultValue());
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return new PageInfo<>(systemParamDtoMapper.selectByExample(param));
    }
}
