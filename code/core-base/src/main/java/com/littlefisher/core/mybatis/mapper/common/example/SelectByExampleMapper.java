package com.littlefisher.core.mybatis.mapper.common.example;


import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.littlefisher.core.mybatis.mapper.common.CommonMapper;
import com.littlefisher.core.mybatis.mapper.provider.example.ExampleProvider;

/**
 * Description: 通用Mapper接口
 *
 * Created on 2018年01月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SelectByExampleMapper<T> extends CommonMapper<T> {

    /**
     * 根据Example条件进行查询非BLOB字段
     *
     * @param example example
     * @return 列表
     */
    @SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
    List<T> selectByExampleWithoutBlob(Object example);
}
