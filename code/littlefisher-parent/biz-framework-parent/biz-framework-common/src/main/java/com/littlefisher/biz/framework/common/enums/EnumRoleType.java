package com.littlefisher.biz.framework.common.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumRoleType.java
 *
 * Created on 2017年12月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumRoleType implements IEnum {

    /** 有效 */
    VALID("有效"),;

    /** 描述 */
    private String desc;

    EnumRoleType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumRoleType enumRoleType : EnumRoleType.values()) {
            if (enumRoleType.getCode().equals(code)) {
                return enumRoleType;
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
