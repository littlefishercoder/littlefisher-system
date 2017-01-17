package com.yc.room1000.core.attr.service;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrCatgDto;

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
public interface IAttrCatgService {

    /**
     * 
     * Description: 根据Id获取AttrCatgDto。仅获取该Dto的属性，其下的子目录和子属性不在其中
     * 
     * @author jinyanan
     *
     * @param catgId catgId
     * @return AttrCatgDto
     */
    AttrCatgDto getSingleAttrCatgDtoById(Long catgId);

    /**
     * 
     * Description: 根据Code获取AttrCatgDto。仅获取该Dto的属性，其下的子目录和子属性不在其中
     * 
     * @author jinyanan
     *
     * @param catgCode catgCode
     * @return AttrCatgDto
     */
    AttrCatgDto getSingleAttrCatgDtoByCode(Long catgCode);

    /**
     * 
     * Description: 根据Id获取AttrCatgDto。同时获取其下的子目录和子属性，递归获取。
     * 
     * @author jinyanan
     *
     * @param catgId catgId
     * @return AttrCatgDto
     */
    AttrCatgDto getAttrCatgIncludeChildrenById(Long catgId);

    /**
     * 
     * Description: 根据Code获取AttrCatgDto。同时获取其下的子目录和子属性，递归获取。
     * 
     * @author jinyanan
     *
     * @param catgCode catgCode
     * @return AttrCatgDto
     */
    AttrCatgDto getAttrCatgIncludeChildrenByCode(Long catgCode);

    /**
     * 
     * Description: 获取所有的根AttrCatgDto。
     * 
     * @author jinyanan
     *
     * @return List<AttrCatgDto>
     */
    List<AttrCatgDto> getAllRootCatg();

    /**
     * 
     * Description: 新增AttrCatgDto
     * 
     * @author jinyanan
     *
     * @param attrCatgDto attrCatgDto
     * @return int
     */
    int addAttrCatgDto(AttrCatgDto attrCatgDto);
    
    /**
     * 
     * Description: 更新AttrCatgDto
     * 
     * @author jinyanan
     *
     * @param attrCatgDto attrCatgDto
     * @return int
     */
    int updateAttrCatgDto(AttrCatgDto attrCatgDto);
    
    /**
     * 
     * Description: 根据Id删除AttrCatgDto。逻辑删除。
     * 
     * @author jinyanan
     *
     * @param catgId catgId
     * @return int
     */
    int deleteAttrCatgDtoById(Long catgId);
    
    /**
     * 
     * Description: 根据Code删除AttrCatgDto。逻辑删除。
     * 
     * @author jinyanan
     *
     * @param catgCode catgCode
     * @return int
     */
    int deleteAttrCatgDtoByCode(Long catgCode);
    
    /**
     * 
     * Description: 把当前目录绑定到父目录上
     * 
     * @author jinyanan
     *
     * @param attrCatgId attrCatgId
     * @param parentCatgId parentCatgId
     */
    void bindAttrCatg(Long attrCatgId, Long parentCatgId);
    
    /**
     * 
     * Description: 当前目录和父目录进行解绑
     * 
     * @author jinyanan
     *
     * @param attrCatgId attrCatgId
     * @param parentCatgId parentCatgId
     */
    void unbindAttrCatg(Long attrCatgId, Long parentCatgId);
}
