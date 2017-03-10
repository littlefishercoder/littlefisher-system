package com.yc.room1000.jyn.attr.cmd;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrPagerListRequest;

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
public class QryAttrPagerByCondCmd extends AbstractCommand {

    /**
     * qryAttrListRequest
     */
    private QryAttrPagerListRequest qryAttrPagerListRequest;
    
    /**
     * QryAttrByConfCmd
     * 
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     */
    public QryAttrPagerByCondCmd(QryAttrPagerListRequest qryAttrPagerListRequest) {
        this.qryAttrPagerListRequest = qryAttrPagerListRequest;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
//        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
//        PageHelper.startPage(qryAttrPagerListRequest.getPageNum(), qryAttrPagerListRequest.getPageSize());
//        return attrDtoMapper.selectAttrByCond(qryAttrPagerListRequest);
        return null;
    }

}
