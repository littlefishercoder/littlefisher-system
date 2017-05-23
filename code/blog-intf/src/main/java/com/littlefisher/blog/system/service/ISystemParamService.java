package com.littlefisher.blog.system.service;

import java.util.List;

import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;

/**
 * Description: 系统信息参数
 * 
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemParamService {

    /**
     * 
     * Description: 根据条件查询
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<SystemParamDto>
     * @throws BaseAppException <br>
     */
    List<SystemParamDto> getSystemParamList4PagerByCond(GetSystemParamList4PagerByCondRequest req)
        throws BaseAppException;

    /**
     * 
     * Description: 根据key值查询系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     * @throws BaseAppException <br>
     */
    SystemParamDto getSystemParamByKey(String paramKey) throws BaseAppException;

    /**
     * 
     * Description: 根据id查询系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     * @throws BaseAppException <br>
     */
    SystemParamDto getSystemParamById(Long systemParamId) throws BaseAppException;

    /**
     * 
     * Description: 新增系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     * @throws BaseAppException <br>
     */
    SystemParamDto addSystemParam(SystemParamDto systemParamDto) throws BaseAppException;

    /**
     * 
     * Description: 根据key删除系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteSystemParamByKey(String paramKey) throws BaseAppException;

    /**
     * 
     * Description: 根据主键删除系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamId systemParamId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteSystemParamById(Long systemParamId) throws BaseAppException;

    /**
     * 
     * Description: 修改系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     * @throws BaseAppException <br>
     */
    SystemParamDto updateSystemParam(SystemParamDto systemParamDto) throws BaseAppException;
}
