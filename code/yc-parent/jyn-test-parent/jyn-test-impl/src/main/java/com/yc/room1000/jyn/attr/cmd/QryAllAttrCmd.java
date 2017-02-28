package com.yc.room1000.jyn.attr.cmd;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;
import com.yc.room1000.jyn.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月16日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAllAttrCmd extends AbstractCommand {

    @Override
    public List<Object> getInputArgs() {
        return null;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectAllAttr();
    }

}
