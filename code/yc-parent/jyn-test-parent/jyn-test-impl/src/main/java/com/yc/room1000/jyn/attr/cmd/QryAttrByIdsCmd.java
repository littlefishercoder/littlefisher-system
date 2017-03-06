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
 * Created on 2017年2月12日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAttrByIdsCmd extends AbstractCommand {
    
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
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        String[] attrIdsArray = attrIds.split(",");
        return attrDtoMapper.selectByIds(attrIdsArray);
    }

}
