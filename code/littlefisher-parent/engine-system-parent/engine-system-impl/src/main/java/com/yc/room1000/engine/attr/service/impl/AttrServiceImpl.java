package com.yc.room1000.engine.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.yc.room1000.engine.attr.cmd.DeleteAttrCmd;
import com.yc.room1000.engine.attr.cmd.InsertAttrCmd;
import com.yc.room1000.engine.attr.cmd.QryAllAttrCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrByIdCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrListByCondCmd;
import com.yc.room1000.engine.attr.cmd.QryAttrPagerListByCondCmd;
import com.yc.room1000.engine.attr.cmd.UpdateAttrCmd;
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

    @Override
    public List<AttrDto> getAllAttr() throws BaseAppException {
        return this.execute(new QryAllAttrCmd());
    }

    @Override
    public AttrDto getAttrById(Long attrId) throws BaseAppException {
        return this.execute(new QryAttrByIdCmd(attrId));
    }

    @Override
    public AttrDto addAttr(AttrDto attrDto) throws BaseAppException {
        return this.execute(new InsertAttrCmd(attrDto));
    }

    @Override
    public AttrDto updateAttr(AttrDto attrDto) throws BaseAppException {
        return this.execute(new UpdateAttrCmd(attrDto));
    }

    @Override
    public int deleteAttr(Long attrId) throws BaseAppException {
        return this.execute(new DeleteAttrCmd(attrId));
    }

    @Override
    public List<AttrDto> getAttrListByCond(QryAttrListRequest qryAttrListRequest) throws BaseAppException {
        return this.execute(new QryAttrListByCondCmd(qryAttrListRequest));
    }

    @Override
    public List<AttrDto> getAttrPagerListByCond(QryAttrPagerListRequest qryAttrPagerListRequest)
        throws BaseAppException {
        return this.execute(new QryAttrPagerListByCondCmd(qryAttrPagerListRequest));
    }

}
