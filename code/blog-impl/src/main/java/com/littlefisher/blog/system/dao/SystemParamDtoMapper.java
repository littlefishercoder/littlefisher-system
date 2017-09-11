package com.littlefisher.blog.system.dao;

import java.util.List;

import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;

import org.apache.ibatis.session.RowBounds;


/**
 *
 * Description: system_param Mapper 接口
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SystemParamDtoMapper extends Mapper<SystemParamDto> {

    /**
     * 
     * Description: 根据paramKey删除系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return int
     */
    int deleteByParamKey(String paramKey);

    /**
     * 
     * Description: 根据paramKey查询系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    SystemParamDto selectByParamKey(String paramKey);

    /**
     * 
     * Description: 根据条件查询系统参数
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<SystemParamDto>
     */
    List<SystemParamDto> selectByCond(GetSystemParamList4PagerByCondRequest req);

    /**
     * 使用Mybatis原生分页进行测试
     * @param req req
     * @param rowBounds 分页参数
     * @return List<SystemParamDto>
     */
    List<SystemParamDto> selectByCond(GetSystemParamList4PagerByCondRequest req, RowBounds rowBounds);
}