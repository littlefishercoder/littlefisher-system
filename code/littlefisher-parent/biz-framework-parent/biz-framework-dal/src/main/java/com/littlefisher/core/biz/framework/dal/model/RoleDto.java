package com.littlefisher.core.biz.framework.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.biz.framework.common.enums.EnumRoleType;


/**
 *
 * Description: bfm_role 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_role")
public class RoleDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 类型
     */
    private EnumRoleType type;

    /**
     * 描述
     */
    @Column(name = "role_desc")
    private String roleDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumRoleType getType() {
        return type;
    }

    public void setType(EnumRoleType type) {
        this.type = type;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", roleDesc=").append(roleDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private RoleDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new RoleDto();
            return builder;
        }

        public static Builder getInstance(RoleDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addName(String name) {
            this.instance.setName(name);
            return this;
        }

        public Builder addType(EnumRoleType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addRoleDesc(String roleDesc) {
            this.instance.setRoleDesc(roleDesc);
            return this;
        }

        public RoleDto build() {
            return this.instance;
        }
    }
}