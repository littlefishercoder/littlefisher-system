package com.littlefisher.blog.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumCountStatisticState.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumCountStatisticState implements IEnum {

    /** 有效 */
    VALID("有效"),
    /** 无效 */
    INVALID("无效"),;

    /** 描述 */
    private String desc;

    EnumCountStatisticState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumCountStatisticState enumCountStatisticState : EnumCountStatisticState.values()) {
            if (enumCountStatisticState.getCode().equals(code)) {
                return enumCountStatisticState;
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
