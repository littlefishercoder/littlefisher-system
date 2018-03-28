package com.littlefisher.blog.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumAuthorState;

/**
 *
 * Description: author 实体
 *
 * Created on 2018年01月10日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "author")
public class AuthorDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键，跟bfm_user表相同主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 笔名
     */
    @Column(name = "pen_name")
    private String penName;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 状态
     */
    private EnumAuthorState state;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    public static class Builder {

        private AuthorDto instance = new AuthorDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addPenName(String penName) {
            this.instance.setPenName(penName);
            return this;
        }

        public Builder addMotto(String motto) {
            this.instance.setMotto(motto);
            return this;
        }

        public Builder addState(EnumAuthorState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public AuthorDto build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public EnumAuthorState getState() {
        return state;
    }

    public void setState(EnumAuthorState state) {
        this.state = state;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", penName=").append(penName);
        sb.append(", motto=").append(motto);
        sb.append(", state=").append(state);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}