package com.littlefisher.blog.enums.post;

import com.littlefisher.core.mybatis.IEnum;

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
    ORIGINAL("A", "原创"),
    /** 翻译 */
    TRANSLATION("B", "翻译"),
    /** 转载 */
    REPRINT("C", "转载"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String desc;

    EnumPostType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public EnumPostState find(String code) {
        for (EnumPostState enumPostState : EnumPostState.values()) {
            if (enumPostState.getCode().equals(code)) {
                return enumPostState;
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
