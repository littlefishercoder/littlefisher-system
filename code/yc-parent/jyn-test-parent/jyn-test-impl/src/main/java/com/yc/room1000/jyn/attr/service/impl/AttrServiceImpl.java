package com.yc.room1000.jyn.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;
import com.yc.room1000.core.utils.ExceptionHandler;
import com.yc.room1000.core.utils.ListUtil;
import com.yc.room1000.jyn.attr.cmd.InsertAttrCmd;
import com.yc.room1000.jyn.attr.cmd.QryAllAttrCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrByConfCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrByIdCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrByIdsCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrByNameCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrPagerByCondCmd;
import com.yc.room1000.jyn.attr.cmd.UpdateAttrCmd;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrListRequest;
import com.yc.room1000.jyn.attr.model.QryAttrPagerListRequest;
import com.yc.room1000.jyn.attr.service.IAttrService;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("AttrService")
public class AttrServiceImpl extends ServiceImpl implements IAttrService {

    @Override
    public AttrDto qryAttrById(Long attrId) throws BaseAppException {
        return (AttrDto) this.execute(new QryAttrByIdCmd(attrId));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> qryAllAttr() throws BaseAppException {
        List<AttrDto> attrList =  (List<AttrDto>) this.execute(new QryAllAttrCmd());
        if (attrList.size() == 4) {
            ExceptionHandler.publish("COMMON-0001");
        }
        return attrList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> qryAttrByIds(String attrIds) throws BaseAppException {
        List<AttrDto> attrList = (List<AttrDto>) this.execute(new QryAttrByIdsCmd(attrIds));
        if (ListUtil.isEmpty(attrList)) {
            ExceptionHandler.publish("ATTR_COMMON_00002");
        }
        return attrList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> getAttrPagerByConf(QryAttrPagerListRequest qryAttrPagerListRequest) throws BaseAppException {
        List<AttrDto> attrList = (List<AttrDto>) this.execute(new QryAttrPagerByCondCmd(qryAttrPagerListRequest));
        return attrList;
    }

    @Override
    public AttrDto addAttr(AttrDto attrDto) throws BaseAppException {
        AttrDto attr =  (AttrDto) this.execute(new InsertAttrCmd(attrDto));
        return attr;
    }

    @Override
    public AttrDto updateAttr(AttrDto attrDto) throws BaseAppException {
        return (AttrDto) this.execute(new UpdateAttrCmd(attrDto));
    }

    @Override
    public int deleteAttrById(Long attrId) throws BaseAppException {
        return (int) this.execute(new DeleteAttrCmd(attrId));
    }

    @Override
    public AttrDto getAttrByName(String attrName) throws BaseAppException {
        return (AttrDto) this.execute(new QryAttrByNameCmd(attrName));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AttrDto> getAttrByConf(QryAttrListRequest qryAttrListRequest) throws BaseAppException {
        return (List<AttrDto>) this.execute(new QryAttrByConfCmd(qryAttrListRequest));
    }

}
