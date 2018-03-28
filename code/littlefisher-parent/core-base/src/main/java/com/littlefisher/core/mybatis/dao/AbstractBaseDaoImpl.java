package com.littlefisher.core.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.core.mybatis.mapper.common.CommonMapper;

/**
 *
 * @author jinyn22648
 * @version $$Id: BaseDaoImpl.java, v 0.1 2018/3/24 上午11:00 jinyn22648 Exp $$
 */
@Repository
public abstract class AbstractBaseDaoImpl<T> implements IBaseDao<T> {

    @Autowired
    private CommonMapper<T> mapper;

    @Override
    public T insert(T record) {
        mapper.insert(record);
        return record;
    }

    @Override
    public T insertSelective(T record) {
        mapper.insertSelective(record);
        return record;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public List<T> selectByRecord(T record) {
        return mapper.select(record);
    }

    @Override
    public T selectOneByRecord(T record) {
        return mapper.selectOne(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T updateByPrimaryKey(T record) {
        mapper.updateByPrimaryKey(record);
        return record;
    }

    @Override
    public T updateByPrimaryKeySelective(T record) {
        mapper.updateByPrimaryKeySelective(record);
        return record;
    }
}
