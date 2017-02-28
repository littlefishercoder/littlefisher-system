package com.yc.room1000.jyn.attr.cmd;

import java.util.ArrayList;
import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;
import com.yc.room1000.jyn.attr.model.AttrDto;

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
public class QryAttrByIdCmd extends AbstractCommand {
    
    /**
     * attrId
     */
    private Long attrId;
    
    /**
     * 构造函数
     * @param attrId attrId
     */
    public QryAttrByIdCmd(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public List<Object> getInputArgs() {
        List<Object> args = new ArrayList<Object>();
        args.add(attrId);
        return args;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectByPrimaryKey(attrId);
    }

}
