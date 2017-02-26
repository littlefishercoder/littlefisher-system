package com.yc.room1000.jyn.attr.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;
import com.yc.room1000.jyn.attr.dao.AttrDtoMapper;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrListRequest;

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
public class QryAttrByConfCmd extends AbstractCommand implements Command, Serializable {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 1L;
    
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
    public List<Object> getInputArgs() {
        List<Object> args = new ArrayList<Object>();
        args.add(qryAttrListRequest);
        return args;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        PageHelper.startPage(qryAttrListRequest.getPageNum(), qryAttrListRequest.getPageSize());
        return attrDtoMapper.selectAllAttr();
    }

}
