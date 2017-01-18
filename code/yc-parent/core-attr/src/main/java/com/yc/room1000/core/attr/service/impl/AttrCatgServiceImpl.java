package com.yc.room1000.core.attr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yc.room1000.core.attr.dao.AttrCatgDtoMapper;
import com.yc.room1000.core.attr.domain.AttrCatgTypeDefine;
import com.yc.room1000.core.attr.dto.AttrCatgDto;
import com.yc.room1000.core.attr.service.IAttrCatgService;
import com.yc.room1000.core.utils.AssertUtil;
import com.yc.room1000.core.utils.ListUtil;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AttrCatgServiceImpl implements IAttrCatgService {
    
    /**
     * attrCatgDtoMapper
     */
    @Autowired
    private AttrCatgDtoMapper attrCatgDtoMapper;

    @Override
    public AttrCatgDto getSingleAttrCatgDtoById(Long catgId) {
        AssertUtil.isNotNull(catgId);
        return attrCatgDtoMapper.selectByPrimaryKey(catgId);
    }

    @Override
    public AttrCatgDto getSingleAttrCatgDtoByCode(String catgCode) {
        AssertUtil.isNotEmpty(catgCode);
        AttrCatgDto record = new AttrCatgDto();
        record.setCatgCode(catgCode);
        List<AttrCatgDto> attrCatgDtoList = attrCatgDtoMapper.selectSelective(record);
        return ListUtil.isNotEmpty(attrCatgDtoList) ? attrCatgDtoList.get(0) : null;
    }

    @Override
    public AttrCatgDto getAttrCatgIncludeChildrenById(Long catgId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AttrCatgDto getAttrCatgIncludeChildrenByCode(Long catgCode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AttrCatgDto> getAllRootCatg() {
        AttrCatgDto record = new AttrCatgDto();
        record.setCatgType(AttrCatgTypeDefine.ROOT_CATG);
        return attrCatgDtoMapper.selectSelective(record);
    }

    @Override
    public int addAttrCatgDto(AttrCatgDto attrCatgDto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateAttrCatgDto(AttrCatgDto attrCatgDto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteAttrCatgDtoById(Long catgId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteAttrCatgDtoByCode(Long catgCode) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void bindAttrCatg(Long attrCatgId, Long parentCatgId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unbindAttrCatg(Long attrCatgId, Long parentCatgId) {
        // TODO Auto-generated method stub

    }

}
