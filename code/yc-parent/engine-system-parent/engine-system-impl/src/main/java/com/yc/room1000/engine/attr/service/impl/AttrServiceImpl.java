package com.yc.room1000.engine.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;
import com.yc.room1000.engine.attr.cmd.InsertAttrCmd;
import com.yc.room1000.engine.attr.cmd.QryAllAttrCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrByIdCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrListByCondCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrPagerListByCondCmd;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;
import com.yc.room1000.engine.attr.model.QryAttrPagerListRequest;
import com.yc.room1000.engine.attr.service.IAttrService;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月28日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("EG.AttrService")
public class AttrServiceImpl extends ServiceImpl implements IAttrService {

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> getAllAttr() throws BaseAppException {
        return (List<AttrDto>) this.execute(new QryAllAttrCmd());
    }

    @Override
    public AttrDto getAttrById(Long attrId) throws BaseAppException {
        return (AttrDto) this.execute(new QryAttrByIdCmd(attrId));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> getAttrListByCond(QryAttrListRequest qryAttrListRequest) throws BaseAppException {
        return (List<AttrDto>) this.execute(new QryAttrListByCondCmd(qryAttrListRequest));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> getAttrPagerListByCond(QryAttrPagerListRequest qryAttrPagerListRequest)
        throws BaseAppException {
        return  (List<AttrDto>) this.execute(new QryAttrPagerListByCondCmd(qryAttrPagerListRequest));
    }

    @Override
    public AttrDto addAttr(AttrDto attrDto) throws BaseAppException {
        return (AttrDto) this.execute(new InsertAttrCmd(attrDto));
    }

}
