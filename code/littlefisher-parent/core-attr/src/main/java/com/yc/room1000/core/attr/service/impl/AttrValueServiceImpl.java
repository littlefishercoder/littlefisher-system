package com.yc.room1000.core.attr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yc.room1000.core.attr.dao.AttrDtoMapper;
import com.yc.room1000.core.attr.dao.AttrValueDtoMapper;
import com.yc.room1000.core.attr.dto.AttrDto;
import com.yc.room1000.core.attr.dto.AttrValueDto;
import com.yc.room1000.core.attr.service.IAttrValueService;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.utils.AssertUtil;
import com.yc.room1000.core.utils.EqualsUtil;
import com.yc.room1000.core.utils.ExceptionUtil;

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
public class AttrValueServiceImpl implements IAttrValueService {
    
    /**
     * attrDtoMapper
     */
    @Autowired
    private AttrDtoMapper attrDtoMapper;
    
    /**
     * attrValueDtoMapper
     */
    @Autowired
    private AttrValueDtoMapper attrValueDtoMapper;

    @Override
    public List<AttrValueDto> getAttrValueDtoListByAttrId(Long attrId) throws BaseAppException {
        AssertUtil.isNotNull(attrId);
        return attrValueDtoMapper.selectAttrValueListByAttrId(attrId);
    }

    @Override
    public List<AttrValueDto> getAttrValueDtoListByAttrCode(String attrCode) throws BaseAppException {
        AttrDto attrDto = attrDtoMapper.selectByCode(attrCode);
        AssertUtil.isNotNull(attrDto);
        return this.getAttrValueDtoListByAttrId(attrDto.getId());
    }

    @Override
    public int addAttrValueDto(AttrValueDto attrValueDto) throws BaseAppException {
        AssertUtil.isNotNull(attrValueDto.getAttrId());
        List<AttrValueDto> attrValueDtoList = this.getAttrValueDtoListByAttrId(attrValueDto.getAttrId());
        AttrValueDto lastAttrValueDto = attrValueDtoList.get(attrValueDtoList.size() - 1);
        // 设置优先级为之前最大优先级 + 1
        attrValueDto.setPriority(lastAttrValueDto.getPriority() + 1);
        return attrValueDtoMapper.insert(attrValueDto);
    }

    @Override
    public int updateAttrValueDto(AttrValueDto attrValueDto) throws BaseAppException {
        AssertUtil.isNotNull(attrValueDto);
        AssertUtil.isNotNull(attrValueDto.getId());
        return attrValueDtoMapper.updateByPrimaryKeySelective(attrValueDto);
    }

    @Override
    public int deleteAttrValueDto(Long attrValueId) throws BaseAppException {
        AssertUtil.isNotNull(attrValueId);
        return attrValueDtoMapper.deleteByPrimaryKey(attrValueId);
    }

    @Override
    public void increasePriority(Long attrValueId) throws BaseAppException {
        AttrValueDto attrValueDto = this.getAttrValueDtoById(attrValueId);
        List<AttrValueDto> attrValueDtoList = this.getAttrValueDtoListByAttrId(attrValueDto.getAttrId());
        AttrValueDto prevAttrValueDto = null;
        for (int i = 0; i < attrValueDtoList.size(); i++) {
            if (EqualsUtil.equals(attrValueDtoList.get(i).getId(), attrValueId)) {
                checkPriority(i, attrValueDtoList.size());
                prevAttrValueDto = attrValueDtoList.get(i - 1);
                break;
            }
        }
        Long tempPriority = attrValueDto.getPriority();
        attrValueDto.setPriority(prevAttrValueDto.getPriority());
        prevAttrValueDto.setPriority(tempPriority);
        this.updateAttrValueDto(attrValueDto);
        this.updateAttrValueDto(prevAttrValueDto);
        
    }

    @Override
    public void decreasePriority(Long attrValueId) throws BaseAppException {
        AttrValueDto attrValueDto = this.getAttrValueDtoById(attrValueId);
        List<AttrValueDto> attrValueDtoList = this.getAttrValueDtoListByAttrId(attrValueDto.getAttrId());
        AttrValueDto nextAttrValueDto = null;
        for (int i = 0; i < attrValueDtoList.size(); i++) {
            if (EqualsUtil.equals(attrValueDtoList.get(i).getId(), attrValueId)) {
                checkPriority(i, attrValueDtoList.size());
                nextAttrValueDto = attrValueDtoList.get(i + 1);
                break;
            }
        }
        Long tempPriority = attrValueDto.getPriority();
        attrValueDto.setPriority(nextAttrValueDto.getPriority());
        nextAttrValueDto.setPriority(tempPriority);
        this.updateAttrValueDto(attrValueDto);
        this.updateAttrValueDto(nextAttrValueDto);
    }
    
    /**
     * 
     * Description: 校验attrValueDto是否已经是第一个或最后一个
     * 
     * @author jinyanan
     *
     * @param i 当前attrValueDto在集合中的下标
     * @param length 集合长度
     * @throws BaseAppException <br>
     */
    private void checkPriority(int i, int length) throws BaseAppException {
        if (i < 1 || i > length - 1) {
            ExceptionUtil.publish("COMMON_ATTR_0001", "The attrValue has been the fisrt one or the last one.");
        }
        
    }
    
    @Override
    public AttrValueDto getAttrValueDtoById(Long attrValueId) throws BaseAppException {
        AssertUtil.isNotNull(attrValueId);
        return attrValueDtoMapper.selectByPrimaryKey(attrValueId);
    }

}
