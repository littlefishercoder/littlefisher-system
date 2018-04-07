package com.littlefisher.blog.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumPostType.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumPostType implements IEnum {
    /** 原创 */
    ORIGINAL("原创"),
    /** 翻译 */
    TRANSLATION("翻译"),
    /** 转载 */
    REPRINT("转载"),;

    /** 描述 */
    private String desc;

    EnumPostType(String desc) {
        this.desc = desc;
    }

    @Override
    public EnumPostState find(String code) {
        for (EnumPostState enumPostState : EnumPostState.values()) {
            if (enumPostState.getCode()
                    .equals(code)) {
                return enumPostState;
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
