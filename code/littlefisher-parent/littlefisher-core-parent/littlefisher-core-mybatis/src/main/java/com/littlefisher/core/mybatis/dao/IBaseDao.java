package com.littlefisher.core.mybatis.dao;

import java.util.List;

/**
 *
 * @author jinyn22648
 * @version $$Id: IBaseDao.java, v 0.1 2018/3/24 上午10:37 jinyn22648 Exp $$
 */
public interface IBaseDao<T> {

    /**
     * 全量插入数据
     * 
     * @param record 数据
     * @return 数据
     */
    T insert(T record);

    /**
     * 插入非null数据
     * 
     * @param record 数据
     * @return 数据
     */
    T insertSelective(T record);

    /**
     * 根据主键删除数据
     * 
     * @param key 主键
     * @return 影响数据条数
     */
    int deleteByPrimaryKey(Object key);

    /**
     * 根据record中非null作为条件查询数据
     * 
     * @param record 数据条件
     * @return 查询出来的数据
     */
    List<T> selectByRecord(T record);

    /**
     * 根据record中非null作为条件查询数据，仅查出至多一条，否则报错
     *
     * @param record 数据条件
     * @return 查询出来的数据
     */
    T selectOneByRecord(T record);

    /**
     * 根据主键查询数据
     * 
     * @param key 主键
     * @return 数据
     */
    T selectByPrimaryKey(Object key);

    /**
     * 查询所有数据
     * 
     * @return 数据
     */
    List<T> selectAll();

    /**
     * 根据record中的主键，全量修改数据 record必须带主键
     * 
     * @param record 数据
     * @return 修改的数据
     */
    T updateByPrimaryKey(T record);

    /**
     * 根据record中的主键，非null字段被修改数据 record必须带主键
     *
     * @param record 数据
     * @return 修改的数据
     */
    T updateByPrimaryKeySelective(T record);
}
