package com.littlefisher.blog.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumCountStatisticType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumCountStatisticType implements IEnum {

    /** 博文 */
    POST("博文"),
    /** 博客 */
    BLOG("博客"),;

    /** 描述 */
    private String desc;

    EnumCountStatisticType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumCountStatisticType enumCountStatisticType : EnumCountStatisticType.values()) {
            if (enumCountStatisticType.getCode().equals(code)) {
                return enumCountStatisticType;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    public String getDesc() {
        return desc;
    }
}
