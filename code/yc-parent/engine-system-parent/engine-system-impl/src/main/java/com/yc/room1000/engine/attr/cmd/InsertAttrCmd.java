package com.yc.room1000.engine.attr.cmd;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.engine.attr.dao.AttrDtoMapper;
import com.yc.room1000.engine.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月1日 
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
     * 
     * InsertAttrCmd
     * 
     * @param attrDto attrDto
     */
    public InsertAttrCmd(AttrDto attrDto) {
        this.attrDto = attrDto;
    }

    @Override
    public List<Object> getInputArgs() {
        return null;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        attrDtoMapper.insert(attrDto);
        return null;
    }

}
