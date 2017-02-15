package com.yc.room1000.attr.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yc.room1000.attr.dao.AttrDtoMapper;
import com.yc.room1000.attr.dto.AttrDto;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;
import com.yc.room1000.core.utils.Room1000Logger;

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
public class QryAttrByIdCmd  extends AbstractCommand implements Command, Serializable {
    
    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 7999911124746553582L;
    
    /**
     * logger
     */
    private static Room1000Logger logger = Room1000Logger.getLogger(QryAttrByIdCmd.class);
    
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
        List<Object> obj = new ArrayList<Object>();
        obj.add(attrId);
        return obj;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
        logger.debug("QryAttrByIdCmd start...");
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectByPrimaryKey(attrId);
    }

}
