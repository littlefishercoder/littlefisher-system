package com.littlefisher.user.common.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumUserContactStation4WebsiteType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStation4WebsiteType implements IEnum {

    /** 博客 */
    BLOG("博客"),
    /** github */
    GITHUB("github"),;

    /** 描述 */
    private String desc;

    EnumUserContactStation4WebsiteType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumUserContactStation4WebsiteType enumUserContactStation4WebsiteType : EnumUserContactStation4WebsiteType
                .values()) {
            if (enumUserContactStation4WebsiteType.getCode().equals(code)) {
                return enumUserContactStation4WebsiteType;
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
