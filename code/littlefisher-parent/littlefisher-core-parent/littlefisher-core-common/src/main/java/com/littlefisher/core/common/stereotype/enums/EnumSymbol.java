/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.littlefisher.core.common.stereotype.enums;

/**
 * @author jinyn22648
 * @version $Id: EnumSymbol.java, v 1.0 2017-10-19 10:20 jinyn22648 Exp $
 */
public enum EnumSymbol {

    /** 反斜杠 */
    BACKSLASH("/", "反斜杠"),

    /** 斜杠 */
    SLASH("\\", "斜杠"),

    /** 逗号 */
    COMMA(",", "逗号"),

    /** 竖线 */
    VERTICAL_LINE("|", "竖线"),

    /** 句号 */
    PERIOD(".", "句号"),

    /** 负号 */
    MINUS("-", "负号"),

    /** 冒号 */
    COLON(":", "冒号"),
    ;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumSymbol(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
