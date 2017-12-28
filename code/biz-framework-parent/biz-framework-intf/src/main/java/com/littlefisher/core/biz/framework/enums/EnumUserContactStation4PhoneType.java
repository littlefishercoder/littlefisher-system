package com.littlefisher.core.biz.framework.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumUserContactStation4PhoneType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStation4PhoneType implements IEnum {

    /** 个人手机号 */
    PERSONAL_CUSTOMER_PHONE("个人手机号"),
    /** 个人固话 */
    PERSONAL_CUSTOMER_HOME_PHONE("个人固话"),;

    /** 描述 */
    private String desc;

    EnumUserContactStation4PhoneType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
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
