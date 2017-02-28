package com.yc.room1000.engine.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;
import com.yc.room1000.engine.attr.cmd.QryAllAttrCmd;
import com.yc.room1000.engine.attr.model.AttrDto;
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

}
