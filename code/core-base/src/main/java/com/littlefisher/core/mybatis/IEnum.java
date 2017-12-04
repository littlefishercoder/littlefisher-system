package com.littlefisher.core.mybatis;

/**
 * Description: IEnum.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IEnum {

    /**
     * 根据编码查询枚举
     * @param code 编码
     * @return 枚举
     */
    IEnum find(String code);

    /**
     * 获取编码
     * @return 编码
     */
    String getCode();
}
