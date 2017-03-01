package com.yc.room1000.engine.attr.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.engine.attr.dao.AttrDtoMapper;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrPagerListRequest;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月1日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAttrPagerListByCondCmd extends AbstractCommand {
    
    /**
     * qryAttrPagerListRequest
     */
    private QryAttrPagerListRequest qryAttrPagerListRequest;
    
    /**
     * QryAttrPagerListByCondCmd
     * 
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     */
    public QryAttrPagerListByCondCmd(QryAttrPagerListRequest qryAttrPagerListRequest) {
        this.qryAttrPagerListRequest = qryAttrPagerListRequest;
    }

//    @Override
//    public List<Object> getInputArgs() {
//        List<Object> args = new ArrayList<>();
//        args.add(qryAttrPagerListRequest);
//        return args;
//    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        PageHelper.startPage(qryAttrPagerListRequest.getPageNum(), qryAttrPagerListRequest.getPageSize());
        return attrDtoMapper.selectByCond(qryAttrPagerListRequest);
    }

}
