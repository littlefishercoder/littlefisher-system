package com.littlefisher.core.biz.framework.enums;

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

    private String desc;

    EnumUserState(String code, String desc) {
        this.code = code;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }
}
