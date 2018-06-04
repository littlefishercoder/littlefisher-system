package com.littlefisher.core.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.littlefisher.core.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * Description: SelectWithoutBlobByPrimaryKeyMapper.java
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SelectWithoutBlobByPrimaryKeyMapper<T> {

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号 不带Blob字段
     *
     * @param key 主键
     * @return 结果
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    T selectWithoutBlobByPrimaryKey(Object key);

}