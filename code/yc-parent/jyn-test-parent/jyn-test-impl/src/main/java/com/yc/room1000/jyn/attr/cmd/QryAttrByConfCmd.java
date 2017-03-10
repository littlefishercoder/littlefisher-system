package com.yc.room1000.jyn.attr.cmd;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrListRequest;

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
public class QryAttrByConfCmd extends AbstractCommand {
    
    /**
     * qryAttrListRequest
     */
    private QryAttrListRequest qryAttrListRequest;
    
    /**
     * QryAttrByConfCmd
     * 
     * @param qryAttrListRequest qryAttrListRequest
     */
    public QryAttrByConfCmd(QryAttrListRequest qryAttrListRequest) {
        this.qryAttrListRequest = qryAttrListRequest;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
//        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
//        return attrDtoMapper.selectAttrByCond(qryAttrListRequest);
        return null;
    }

}
