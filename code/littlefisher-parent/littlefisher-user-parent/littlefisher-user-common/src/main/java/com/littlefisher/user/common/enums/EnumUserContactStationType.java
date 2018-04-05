package com.littlefisher.user.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumUserContactStationType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStationType implements IEnum {

    /** 电话 */
    TELEPHONE("电话"),
    /** 邮箱 */
    EMAIL("邮箱"),
    /** 地址 */
    ADDRESS("地址"),
    /** 社交 */
    SOCIAL("社交"),
    /** 网站 */
    WEBSITE("网站"),;

    /**  */
    private String desc;

    EnumUserContactStationType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumUserContactStationType enumUserContactStationType : EnumUserContactStationType.values()) {
            if (enumUserContactStationType.getCode().equals(code)) {
                return enumUserContactStationType;
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
