package com.yc.room1000.engine.attr.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.yc.room1000.engine.attr.dao.AttrDtoMapper;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrPagerListRequest;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAttrPagerListByCond extends AbstractCommand<List<AttrDto>> {
    
    /**
     * qryAttrPagerListRequest
     */
    private QryAttrPagerListRequest qryAttrPagerListRequest;

    /**
     * QryAttrPagerListByCond
     * 
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     */
    public QryAttrPagerListByCond(QryAttrPagerListRequest qryAttrPagerListRequest) {
        this.qryAttrPagerListRequest = qryAttrPagerListRequest;
    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        PageHelper.startPage(qryAttrPagerListRequest.getPageNum(), qryAttrPagerListRequest.getPageSize());
        return attrDtoMapper.selectByCond(qryAttrPagerListRequest);
    }

}
