package com.littlefisher.blog.enums.user;

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
    VALID("A", "有效"),
    ;

    /** 编码 */
    private String code;

    /** 描述 */
    private String desc;

    EnumRoleType(String code, String desc) {
        this.code = code;
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
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
