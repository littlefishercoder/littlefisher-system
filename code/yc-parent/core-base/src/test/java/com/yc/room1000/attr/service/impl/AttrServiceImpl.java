package com.yc.room1000.attr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.room1000.attr.cmd.QryAttrByIdCmd;
import com.yc.room1000.attr.dto.AttrDto;
import com.yc.room1000.attr.service.IAttrService;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("AttrService")
public class AttrServiceImpl extends ServiceImpl implements IAttrService {
    
    @Override
    public List<AttrDto> selectAll() {
        return null;
    }

    @Override
    public AttrDto selectById(Long attrId) throws BaseAppException {
        return (AttrDto) this.execute(new QryAttrByIdCmd(attrId));
    }

}
