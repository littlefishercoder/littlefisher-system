package com.littlefisher.user.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * Description: bfm_user_role 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user_role")
public class UserRoleDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户主键
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色主键
     */
    @Column(name = "role_id")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private UserRoleDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new UserRoleDto();
            return builder;
        }

        public static Builder getInstance(UserRoleDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addUserId(Long userId) {
            this.instance.setUserId(userId);
            return this;
        }

        public Builder addRoleId(Long roleId) {
            this.instance.setRoleId(roleId);
            return this;
        }

        public UserRoleDto build() {
            return this.instance;
        }
    }
}