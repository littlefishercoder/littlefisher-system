package com.littlefisher.core.mybatis.mapper.common.base.select;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.littlefisher.core.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * Description: SelectWithoutBlobMapper.java
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SelectWithoutBlobMapper<T> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * 不带Blob字段
     *
     * @param record 条件
     * @return 结果
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectWithoutBlob(T record);

}