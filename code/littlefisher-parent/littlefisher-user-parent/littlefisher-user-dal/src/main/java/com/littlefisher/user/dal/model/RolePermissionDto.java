package com.littlefisher.user.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * Description: bfm_role_permission 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_role_permission")
public class RolePermissionDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限主键
     */
    @Column(name = "permission_id")
    private Long permissionId;

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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
        sb.append(", permissionId=").append(permissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private RolePermissionDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new RolePermissionDto();
            return builder;
        }

        public static Builder getInstance(RolePermissionDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addPermissionId(Long permissionId) {
            this.instance.setPermissionId(permissionId);
            return this;
        }

        public Builder addRoleId(Long roleId) {
            this.instance.setRoleId(roleId);
            return this;
        }

        public RolePermissionDto build() {
            return this.instance;
        }
    }
}