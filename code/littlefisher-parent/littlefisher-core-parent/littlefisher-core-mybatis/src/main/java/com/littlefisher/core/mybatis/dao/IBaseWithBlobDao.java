package com.littlefisher.core.mybatis.dao;

import java.util.List;

/**
 *
 * @author jinyn22648
 * @version $$Id: IBaseWithBlobDao.java, v 0.1 2018/3/28 上午9:12 jinyn22648 Exp $$
 */
public interface IBaseWithBlobDao<T> extends IBaseDao<T> {

    /**
     * 根据record中非null作为条件查询数据
     *
     * @param record 数据条件
     * @return 查询出来的数据
     */
    List<T> selectWithoutBlobByRecord(T record);

    /**
     * 根据record中非null作为条件查询数据，仅查出至多一条，否则报错
     *
     * @param record 数据条件
     * @return 查询出来的数据
     */
    T selectOneWithoutBlobByRecord(T record);

    /**
     * 根据主键查询数据
     *
     * @param key 主键
     * @return 数据
     */
    T selectWithoutBlobByPrimaryKey(Object key);

    /**
     * 查询所有数据
     *
     * @return 数据
     */
    List<T> selectAllWithoutBlob();
}
