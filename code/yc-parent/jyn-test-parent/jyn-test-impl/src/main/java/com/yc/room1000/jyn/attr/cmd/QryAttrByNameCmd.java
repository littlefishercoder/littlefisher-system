package com.yc.room1000.jyn.attr.cmd;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;
import com.yc.room1000.jyn.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月27日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAttrByNameCmd extends AbstractCommand {
    
    /**
     * attrName
     */
    private String attrName;
    
    /**
     * QryAttrByNameCmd
     * 
     * @param attrName attrName
     */
    public QryAttrByNameCmd(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectByName(attrName);
    }

}
