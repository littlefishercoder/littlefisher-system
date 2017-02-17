package com.yc.room1000.jyn.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;
import com.yc.room1000.jyn.attr.cmd.QryAllAttrCmd;
import com.yc.room1000.jyn.attr.cmd.QryAttrByIdCmd;
import com.yc.room1000.jyn.attr.model.AttrDto;
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
        return (List<AttrDto>) this.execute(new QryAllAttrCmd());
    }

}
