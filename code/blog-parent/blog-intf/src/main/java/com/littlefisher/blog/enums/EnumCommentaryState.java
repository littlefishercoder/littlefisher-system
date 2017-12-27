package com.littlefisher.blog.enums;

import com.littlefisher.core.mybatis.IEnum;

/**
 * Description: EnumCommentaryState.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumCommentaryState implements IEnum {

    /** 已发布 */
    PUBLISHED("已发布"),
    /** 已删除 */
    DELETED("已删除"),;

    /** 描述 */
    private String desc;

    EnumCommentaryState(String desc) {
        this.desc = desc;
    }

    /**
     * 根据code查询枚举
     * @param code 编码
     * @return 枚举
     */
    @Override
    public EnumCommentaryState find(String code) {
        for (EnumCommentaryState enumCommentaryState : EnumCommentaryState.values()) {
            if (enumCommentaryState.getCode().equals(code)) {
                return enumCommentaryState;
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
