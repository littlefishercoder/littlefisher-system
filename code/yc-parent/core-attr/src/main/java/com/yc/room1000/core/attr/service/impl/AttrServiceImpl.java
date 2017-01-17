package com.yc.room1000.core.attr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.room1000.core.attr.dao.AttrDtoMapper;
import com.yc.room1000.core.attr.dto.AttrDto;
import com.yc.room1000.core.attr.service.IAttrService;

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

    @Override
    public AttrDto getAttrDtoByCode(String attrCode) {
        return attrDtoMapper.selectByCode(attrCode);
    }

    @Override
    public int addAttrDto(AttrDto attrDto) {
        return attrDtoMapper.insert(attrDto);
    }

    @Override
    public int updateAttrDto(AttrDto attrDto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteAttrDtoById(Long attrId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteAttrDtoByCode(String attrCode) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void bindAttrCatg(Long attrId, Long attrCatgId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void unbindAttrCatg(Long attrId, Long attrCatgId) {
        // TODO Auto-generated method stub
        
    }

}
