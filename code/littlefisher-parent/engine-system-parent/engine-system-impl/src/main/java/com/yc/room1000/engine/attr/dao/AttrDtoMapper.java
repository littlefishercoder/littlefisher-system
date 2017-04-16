package com.yc.room1000.engine.attr.dao;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;


/**
 *
 * Description: attr Mapper 接口
 *
 * Created on 2017年03月10日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface AttrDtoMapper extends Mapper<AttrDto> {

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return <br>
     */
    List<AttrDto> selectByCond(QryAttrListRequest qryAttrListRequest);
}