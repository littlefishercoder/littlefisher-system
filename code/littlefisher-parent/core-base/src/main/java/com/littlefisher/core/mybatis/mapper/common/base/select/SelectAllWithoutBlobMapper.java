package com.littlefisher.core.mybatis.mapper.common.base.select;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.littlefisher.core.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * Description: SelectAllWithoutBlobMapper.java
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SelectAllWithoutBlobMapper<T> {

    /**
     * 查询不带Blob字段的全部结果
     *
     * @return 结果集
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectAllWithoutBlob();
}
