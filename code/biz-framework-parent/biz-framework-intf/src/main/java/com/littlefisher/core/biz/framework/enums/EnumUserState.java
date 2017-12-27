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
    VALID("有效"),
    /** 失效 */
    INVALID("失效"),
    ;

    private String desc;

    EnumUserState(String desc) {
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
        return this.name();
    }

    public String getDesc() {
        return desc;
    }
}
