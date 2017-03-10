package com.yc.room1000.jyn.attr.cmd;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
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
public class UpdateAttrCmd extends AbstractCommand {
    
    /**
     * attrDto
     */
    private AttrDto attrDto;
    
    /**
     * UpdateAttrCmd
     * 
     * @param attrDto attrDto
     */
    public UpdateAttrCmd(AttrDto attrDto) {
        this.attrDto = attrDto;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
//        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
//        attrDtoMapper.updateByPrimaryKeySelective(attrDto);
//        return attrDto;
        return null;
    }

}
