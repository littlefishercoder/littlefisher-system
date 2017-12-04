package com.littlefisher.blog.enums.user;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumUserState.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserState implements IEnum {

    /** 有效 */
    VALID("A", "有效"),
    /** 失效 */
    INVALID("X", "失效"),
    ;

    private String code;

    private String description;

    EnumUserState(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public EnumUserState find(String code) {
        for (EnumUserState enumUserState : EnumUserState.values()) {
            if (enumUserState.getCode().equals(code)) {
                return enumUserState;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
