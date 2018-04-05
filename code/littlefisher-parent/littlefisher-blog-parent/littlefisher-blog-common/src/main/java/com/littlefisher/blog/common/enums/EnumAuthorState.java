package com.littlefisher.blog.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumAuthorState.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumAuthorState implements IEnum {

    /** 有效 */
    VALID("有效"),
    /** 无效 */
    INVALID("无效"),;

    /** 描述 */
    private String desc;

    EnumAuthorState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumAuthorState enumAuthorState : EnumAuthorState.values()) {
            if (enumAuthorState.getCode().equals(code)) {
                return enumAuthorState;
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
