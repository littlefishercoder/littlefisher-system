package com.littlefisher.core.datasource.interceptor.cfg;

/**
 * Description: EnumOvalErrorCode.java
 *
 * Created on 2017年11月15日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumOvalErrorCode {
    /** 字段为空 */
    PROPERTY_NULL(OvalErrorCode.PROPERTY_NULL, "字段为空"),
    /** 字段长度不符 */
    PROPERTY_LENGTH(OvalErrorCode.PROPERTY_LENGTH, "字段长度不符"),
    /** 字段规则不符 */
    PROPERTY_PATTERN(OvalErrorCode.PROPERTY_PATTERN, "字段规则不符"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumOvalErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据编码查找枚举
     *
     * @param code 编码
     * @return EnumOvalErrorCode 实例
     **/
    public static EnumOvalErrorCode find(String code) {
        for (EnumOvalErrorCode frs : EnumOvalErrorCode.values()) {
            if (frs.getCode().equals(code)) {
                return frs;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
