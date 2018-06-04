package com.littlefisher.blog.common.enums;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumPostState.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumPostState implements IEnum {

    /** 已发布 */
    PUBLISHED("已发布"),
    /** 精华文章不可删除 */
    ESSENCE("精华"),
    /** 草稿 */
    DRAFT("草稿"),
    /** 已归档的内容禁止评论，文章不可删除 */
    PIGEONHOLE("已归档"),
    /** 已推至首页 */
    INDEX("已推至首页"),
    /** 已删除 */
    DELETED("已删除"),;


    /** 描述 */
    private String desc;

    EnumPostState(String desc) {
        this.desc = desc;
    }

    @Override
    public IEnum find(String code) {
        for (EnumPostState enumPostState : EnumPostState.values()) {
            if (enumPostState.getCode().equals(code)) {
                return enumPostState;
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
