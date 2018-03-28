/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.littlefisher.core.stereotype.enums;

/**
 * @author jinyn22648
 * @version $Id: EnumBool.java, v 1.0 2017-09-11 9:53 jinyn22648 Exp $
 */
public enum EnumBool {

    /** 真 */
    TRUE("TRUE", "真"),
    /** 假 */
    FALSE("FALSE", "假"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumBool(String code, String description) {
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
