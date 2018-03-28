package com.littlefisher.core.stereotype.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumBizBool.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumBizBool implements IEnum {

    /** 真 */
    YES("真"),
    /** 假 */
    NO("假"),;

    /** 描述 */
    private String desc;

    EnumBizBool(String desc) {
        this.desc = desc;
    }

    @Override
    public EnumBizBool find(String code) {
        for (EnumBizBool enumBizBool : EnumBizBool.values()) {
            if (enumBizBool.getCode()
                    .equals(code)) {
                return enumBizBool;
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
