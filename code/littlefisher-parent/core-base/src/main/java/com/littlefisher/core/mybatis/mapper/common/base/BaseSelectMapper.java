package com.littlefisher.core.mybatis.mapper.common.base;

import com.littlefisher.core.mybatis.mapper.common.base.select.SelectAllWithoutBlobMapper;
import com.littlefisher.core.mybatis.mapper.common.base.select.SelectWithoutBlobByPrimaryKeyMapper;
import com.littlefisher.core.mybatis.mapper.common.base.select.SelectWithoutBlobMapper;
import com.littlefisher.core.mybatis.mapper.common.base.select.SelectOneWithoutBlobMapper;

/**
 * Description: BaseSelectMapper.java
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface BaseSelectMapper<T>
    extends SelectAllWithoutBlobMapper<T>, SelectWithoutBlobByPrimaryKeyMapper<T>,
        SelectWithoutBlobMapper<T>, SelectOneWithoutBlobMapper<T> {

}
