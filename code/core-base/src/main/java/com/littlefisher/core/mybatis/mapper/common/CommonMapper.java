package com.littlefisher.core.mybatis.mapper.common;

import tk.mybatis.mapper.common.Mapper;

import com.littlefisher.core.mybatis.mapper.common.example.SelectByExampleMapper;

/**
 * Description: CommonMapper.java
 *
 * Created on 2018年01月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommonMapper<T> extends Mapper<T>, SelectByExampleMapper<T> {
}
