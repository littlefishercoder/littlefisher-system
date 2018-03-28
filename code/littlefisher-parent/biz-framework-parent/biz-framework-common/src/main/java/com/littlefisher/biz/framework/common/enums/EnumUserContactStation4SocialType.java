package com.littlefisher.biz.framework.common.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumUserContactStation4SocialType.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumUserContactStation4SocialType implements IEnum {

    /** QQ */
    QQ("QQ"),
    /** 微信 */
    WECHAT("微信"),
    /** 微博 */
    SINA("微博"),
    /** 旺旺 */
    WANGWANG("旺旺"),
    /** 脉脉 */
    MAIMAI("脉脉"),;

    /** 描述 */
    private String desc;

    EnumUserContactStation4SocialType(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumUserContactStation4SocialType enumUserContactStation4SocialType : EnumUserContactStation4SocialType
                .values()) {
            if (enumUserContactStation4SocialType.getCode().equals(code)) {
                return enumUserContactStation4SocialType;
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
