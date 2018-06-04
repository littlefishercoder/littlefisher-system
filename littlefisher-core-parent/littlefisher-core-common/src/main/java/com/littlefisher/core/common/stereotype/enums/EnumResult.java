package com.littlefisher.core.common.stereotype.enums;


/**
 * Description: EnumResult.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumResult implements IEnum {
    /** 成功 */
    SUCCESS("成功"),
    /** 失败 */
    FAIL("失败");

    /** 描述 */
    private String desc;

    EnumResult(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumResult enumResult : EnumResult.values()) {
            if (enumResult.getCode()
                    .equals(code)) {
                return enumResult;
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
