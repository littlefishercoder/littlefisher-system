package com.yc.room1000.jyn.attr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;

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
public class DeleteAttrCmd extends AbstractCommand implements Command {
    
    /**
     * attrId
     */
    private Long attrId;

    @Override
    public List<Object> getInputArgs() {
        List<Object> args = new ArrayList<Object>();
        args.add(attrId);
        return args;
    }
    
    /**
     * DeleteAttrCmd
     * 
     * @param attrId attrId
     */
    public DeleteAttrCmd(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public Integer execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.deleteByPrimaryKey(attrId);
    }

}
