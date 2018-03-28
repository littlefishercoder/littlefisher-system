package com.littlefisher.core.biz.framework.dal.dao;

import com.littlefisher.core.biz.framework.dal.model.SystemParamDto;
import com.littlefisher.core.biz.framework.dal.param.SelectSystemParam4PageByCondParam;
import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: ISystemParamDtoDao.java, v 0.1 2018/3/23 下午4:14 jinyn22648 Exp $$
 */
public interface ISystemParamDtoDao extends IBaseDao<SystemParamDto> {

    /**
     * 根据paramKey删除系统参数
     * 
     * @param systemParamKey 系统参数key
     * @return 影响到的数据条数
     */
    int deleteByParamKey(String systemParamKey);

    /**
     * 根据paramKey查找系统参数
     * 
     * @param systemParamKey 系统参数key
     * @return 系统参数
     */
    SystemParamDto selectByParamKey(String systemParamKey);

    /**
     * 分页查询数据
     * @param param 条件
     * @param pageParam 分页参数
     * @return 分页数据
     */
    PageInfo<SystemParamDto> selectSystemParam4PageByCond(SelectSystemParam4PageByCondParam param, PageParam pageParam);

}
