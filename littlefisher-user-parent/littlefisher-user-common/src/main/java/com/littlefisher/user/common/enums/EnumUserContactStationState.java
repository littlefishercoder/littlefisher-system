package com.littlefisher.user.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumUserContactStationState.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStationState implements IEnum {
    /** 有效 */
    VALID("有效"),
    /** 失效 */
    INVALID("失效"),;

    /** 描述 */
    private String desc;

    EnumUserContactStationState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumUserContactStationState enumUserContactStationState : EnumUserContactStationState.values()) {
            if (enumUserContactStationState.getCode().equals(code)) {
                return enumUserContactStationState;
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
