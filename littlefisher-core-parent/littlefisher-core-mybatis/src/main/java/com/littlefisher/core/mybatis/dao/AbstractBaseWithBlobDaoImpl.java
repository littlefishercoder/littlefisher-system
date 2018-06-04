package com.littlefisher.core.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.mybatis.mapper.common.CommonMapper;

/**
 *
 * @author jinyn22648
 * @version $$Id: AbstractBaseWithBlobDao.java, v 0.1 2018/3/28 上午9:13 jinyn22648 Exp $$
 */
public abstract class AbstractBaseWithBlobDaoImpl<T, D extends CommonMapper<T>> extends AbstractBaseDaoImpl<T, D> implements IBaseWithBlobDao<T> {

    @Autowired
    private D mapper;

    @Override
    public List<T> selectWithoutBlobByRecord(T record) {
        return mapper.selectWithoutBlob(record);
    }

    @Override
    public T selectOneWithoutBlobByRecord(T record) {
        return mapper.selectOneWithoutBlob(record);
    }

    @Override
    public T selectWithoutBlobByPrimaryKey(Object key) {
        return mapper.selectWithoutBlobByPrimaryKey(key);
    }

    @Override
    public List<T> selectAllWithoutBlob() {
        return mapper.selectAllWithoutBlob();
    }
}
