package com.littlefisher.blog.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.blog.common.enums.EnumCountStatisticState;
import com.littlefisher.blog.common.enums.EnumCountStatisticType;


/**
 *
 * Description: count_statistic 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "count_statistic")
public class CountStatisticDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 作者id
     */
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 统计类型
     */
    private EnumCountStatisticType type;

    /**
     * 状态
     */
    private EnumCountStatisticState state;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public EnumCountStatisticType getType() {
        return type;
    }

    public void setType(EnumCountStatisticType type) {
        this.type = type;
    }

    public EnumCountStatisticState getState() {
        return state;
    }

    public void setState(EnumCountStatisticState state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        sb.append(", authorId=").append(authorId);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private CountStatisticDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new CountStatisticDto();
            return builder;
        }

        public static Builder getInstance(CountStatisticDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addAuthorId(Long authorId) {
            this.instance.setAuthorId(authorId);
            return this;
        }

        public Builder addType(EnumCountStatisticType type) {
            this.instance.setType(type);
            return this;
        }

        public Builder addState(EnumCountStatisticState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addCreateDate(Date createDate) {
            this.instance.setCreateDate(createDate);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public CountStatisticDto build() {
            return this.instance;
        }
    }
}