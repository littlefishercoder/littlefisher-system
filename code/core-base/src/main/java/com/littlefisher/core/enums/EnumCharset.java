/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.littlefisher.core.enums;

/**
 * @author jinyn22648
 * @version $Id: EnumCharset.java, v 1.0 2017-10-19 10:31 jinyn22648 Exp $
 */
public enum EnumCharset {

    /** UTF-8 */
    UTF_8("UTF-8", "UTF-8"),

    /** GBK */
    GBK("GBK", "GBK"),

    /** GB2312 */
    GB2312("GB2312", "GB2312"),

    /** 8859_1 */
    ISO_8859_1("8859_1", "8859_1"),
    ;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumCharset(String code, String description) {
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
