package com.littlefisher.user.common.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumUserContactStation4EmailType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStation4EmailType implements IEnum {

    /** 个人邮箱 */
    PERSONAL_MAILBOX("个人邮箱"),
    /** 企业邮箱 */
    OFFICE_MAILBOX("企业邮箱"),;

    /** 描述 */
    private String desc;

    EnumUserContactStation4EmailType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumUserContactStation4EmailType enumUserContactStation4EmailType : EnumUserContactStation4EmailType
                .values()) {
            if (enumUserContactStation4EmailType.getCode().equals(code)) {
                return enumUserContactStation4EmailType;
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
