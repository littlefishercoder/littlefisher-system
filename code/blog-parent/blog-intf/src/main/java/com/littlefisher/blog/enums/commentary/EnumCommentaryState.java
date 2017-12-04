package com.littlefisher.blog.enums.commentary;

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
    PUBLISHED("A", "已发布"),
    /** 已删除 */
    DELETED("X", "已删除"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumCommentaryState(String code, String description) {
        this.code = code;
        this.description = description;
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
        return code;
    }

    public String getDescription() {
        return description;
    }
}
