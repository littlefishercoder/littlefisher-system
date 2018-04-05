package com.littlefisher.blog.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumArchiveState.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumArchiveState implements IEnum {

    /** 有效 */
    VALID("有效"),
    /** 无效 */
    INVALID("无效"),;

    /** 描述 */
    private String desc;

    EnumArchiveState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumArchiveState enumArchiveState : EnumArchiveState.values()) {
            if (enumArchiveState.getCode().equals(code)) {
                return enumArchiveState;
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
