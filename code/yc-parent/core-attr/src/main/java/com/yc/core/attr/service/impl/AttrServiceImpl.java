package com.yc.core.attr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.core.attr.dao.AttrDtoMapper;
import com.yc.core.attr.dto.AttrDto;
import com.yc.core.attr.service.IAttrService;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月16日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("YC.AttrService")
public class AttrServiceImpl implements IAttrService {
    
    /**
     * attrDtoMapper
     */
    @Autowired
    private AttrDtoMapper attrDtoMapper;

    @Override
    public AttrDto getAttrDtoById(Long attrId) {
        return attrDtoMapper.selectByPrimaryKey(attrId);
    }

}
