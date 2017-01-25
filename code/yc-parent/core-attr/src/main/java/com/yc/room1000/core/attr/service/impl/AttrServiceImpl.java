package com.yc.room1000.core.attr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.room1000.core.attr.dao.AttrCatgChildrenDtoMapper;
import com.yc.room1000.core.attr.dao.AttrCatgDtoMapper;
import com.yc.room1000.core.attr.dao.AttrDtoMapper;
import com.yc.room1000.core.attr.dto.AttrCatgChildrenDto;
import com.yc.room1000.core.attr.dto.AttrCatgDto;
import com.yc.room1000.core.attr.dto.AttrDto;
import com.yc.room1000.core.attr.service.IAttrService;
import com.yc.room1000.core.utils.AssertUtil;

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
    
    /**
     * attrCatgDtoMapper
     */
    @Autowired
    private AttrCatgDtoMapper attrCatgDtoMapper;
    
    /**
     * attrCatgChildrenDtoMapper
     */
    @Autowired
    private AttrCatgChildrenDtoMapper attrCatgChildrenDtoMapper;

    @Override
    public AttrDto getAttrDtoById(Long attrId) {
        AssertUtil.isNotNull(attrId);
        return attrDtoMapper.selectByPrimaryKey(attrId);
    }

    @Override
    public AttrDto getAttrDtoByCode(String attrCode) {
        AssertUtil.isNotEmpty(attrCode);
        return attrDtoMapper.selectByCode(attrCode);
    }

    @Override
    public int addAttrDto(AttrDto attrDto) {
        AssertUtil.isNotNull(attrDto);
        AssertUtil.isNotNull(attrDto.getId());
        return attrDtoMapper.insert(attrDto);
    }

    @Override
    public int updateAttrDto(AttrDto attrDto) {
        AssertUtil.isNotNull(attrDto);
        AssertUtil.isNotNull(attrDto.getId());
        return attrDtoMapper.updateByPrimaryKeySelective(attrDto);
    }

    @Override
    public int deleteAttrDtoById(Long attrId) {
        AssertUtil.isNotNull(attrId);
        return attrDtoMapper.deleteByPrimaryKey(attrId);
    }

    @Override
    public int deleteAttrDtoByCode(String attrCode) {
        AssertUtil.isNotEmpty(attrCode);
        AttrDto attrDto = attrDtoMapper.selectByCode(attrCode);
        return this.deleteAttrDtoById(attrDto.getId());
    }

    @Override
    public void bindAttrCatg(Long attrId, Long attrCatgId) {
        AttrDto attrDto = this.getAttrDtoById(attrId);
        AttrCatgDto attrCatgDto = attrCatgDtoMapper.selectByPrimaryKey(attrCatgId);
        AssertUtil.isNotNull(attrDto);
        AssertUtil.isNotNull(attrCatgDto);
        
        AttrCatgChildrenDto attrCatgChildrenDto = new AttrCatgChildrenDto();
        attrCatgChildrenDto.setCatgId(attrCatgId);
        attrCatgChildrenDto.setChildAttrId(attrId);
        attrCatgChildrenDtoMapper.insert(attrCatgChildrenDto);
        
    }

    @Override
    public void unbindAttrCatg(Long attrId, Long attrCatgId) {
        AttrDto attrDto = this.getAttrDtoById(attrId);
        AttrCatgDto attrCatgDto = attrCatgDtoMapper.selectByPrimaryKey(attrCatgId);
        AssertUtil.isNotNull(attrDto);
        AssertUtil.isNotNull(attrCatgDto);
        
        AttrCatgChildrenDto attrCatgChildrenDto = new AttrCatgChildrenDto();
        attrCatgChildrenDto.setCatgId(attrCatgId);
        attrCatgChildrenDto.setChildAttrId(attrId);
        AttrCatgChildrenDto attrCatgChildrenTempDto = attrCatgChildrenDtoMapper.selectSelective(attrCatgChildrenDto);
        if (attrCatgChildrenTempDto != null) {
            attrCatgChildrenDtoMapper.deleteByPrimaryKey(attrCatgChildrenTempDto.getId());
        }
    }

    @Override
    public List<AttrDto> getAttrList() {
        return attrDtoMapper.selectAllAttr();
    }

}
