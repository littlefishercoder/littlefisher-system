package com.yc.room1000.jyn.attr.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;
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
public class QryAttrByIdsCmd extends AbstractCommand implements Command, Serializable {
    
    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 5984638442611320531L;
    /**
     * attrId
     */
    private String attrIds;
    
    /**
     * 构造函数
     * @param attrIds attrIds
     */
    public QryAttrByIdsCmd(String attrIds) {
        this.attrIds = attrIds;
    }

    @Override
    public List<Object> getInputArgs() {
        List<Object> args = new ArrayList<Object>();
        args.add(attrIds);
        return args;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        String[] attrIdsArray = attrIds.split(",");
        return attrDtoMapper.selectByIds(attrIdsArray);
    }

}
