package com.littlefisher.core.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.littlefisher.core.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * Description: SelectOneWithoutBlobMapper.java
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SelectOneWithoutBlobMapper<T> {

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号 不带Blob字段
     *
     * @param record 条件
     * @return 结果
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    T selectOneWithoutBlob(T record);

}