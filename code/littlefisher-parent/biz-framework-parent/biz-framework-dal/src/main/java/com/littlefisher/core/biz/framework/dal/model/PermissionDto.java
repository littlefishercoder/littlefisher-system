package com.littlefisher.core.biz.framework.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * Description: bfm_permission 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_permission")
public class PermissionDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 描述
     */
    @Column(name = "permission_desc")
    private String permissionDesc;

    public static class Builder {

        private PermissionDto instance = new PermissionDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addCode(String code) {
            this.instance.setCode(code);
            return this;
        }

        public Builder addPermissionDesc(String permissionDesc) {
            this.instance.setPermissionDesc(permissionDesc);
            return this;
        }

        public PermissionDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", permissionDesc=").append(permissionDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}