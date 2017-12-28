package com.littlefisher.blog.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumPostTagState.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumPostTagState implements IEnum {

    /** 有效 */
    VALID("有效"),
    /** 无效 */
    INVALID("无效"),
    ;

    /** 描述 */
    private String desc;

    EnumPostTagState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumPostTagState enumPostTagState : EnumPostTagState.values()) {
            if (enumPostTagState.getCode().equals(code)) {
                return enumPostTagState;
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
