package com.yc.room1000.jyn.attr.cmd;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;
import com.yc.room1000.jyn.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月26日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class InsertAttrCmd extends AbstractCommand {

    /**
     * attrDto
     */
    private AttrDto attrDto;
    
    /**
     * InsertAttrCmd
     * 
     * @param attrDto attrDto
     */
    public InsertAttrCmd(AttrDto attrDto) {
        this.attrDto = attrDto;
    }
    
    @Override
    public AttrDto execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        attrDtoMapper.insert(attrDto);
        return attrDto;
    }

}
