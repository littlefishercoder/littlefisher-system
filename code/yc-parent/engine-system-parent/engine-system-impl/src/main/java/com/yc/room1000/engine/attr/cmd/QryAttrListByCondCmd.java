package com.yc.room1000.engine.attr.cmd;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.engine.attr.dao.AttrDtoMapper;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;

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
public class QryAttrListByCondCmd extends AbstractCommand {
    
    /**
     * qryAttrListRequest
     */
    private QryAttrListRequest qryAttrListRequest;
    
    /**
     * QryAttrListByCondCmd
     * 
     * @param qryAttrListRequest qryAttrListRequest
     */
    public QryAttrListByCondCmd(QryAttrListRequest qryAttrListRequest) {
        this.qryAttrListRequest = qryAttrListRequest;
    }

//    @Override
//    public List<Object> getInputArgs() {
//        List<Object> args = new ArrayList<>();
//        args.add(qryAttrListRequest);
//        return args;
//    }

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectByCond(qryAttrListRequest);
    }

}
