package com.littlefisher.blog.enums.post;

import com.littlefisher.core.mybatis.IEnum;

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
    PUBLISHED("A", "已发布"),
    /** 精华文章不可删除 */
    ESSENCE("B", "精华"),
    /** 草稿 */
    DRAFT("C", "草稿"),
    /** 已归档的内容禁止评论，文章不可删除 */
    PIGEONHOLE("D", "已归档"),
    /** 已推至首页 */
    INDEX("E", "已推至首页"),
    /** 已删除 */
    DELETED("X", "已删除"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String desc;

    EnumPostState(String code, String desc) {
        this.code = code;
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
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
