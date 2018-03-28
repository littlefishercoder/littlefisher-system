package com.littlefisher.blog.dal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumTagState;

/**
 *
 * Description: tag 实体
 *
 * Created on 2018年01月10日
 * 
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "tag")
public class TagDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称(唯一)
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 状态
     */
    private EnumTagState state;

    /**
     * 状态变更时间
     */
    @Column(name = "state_date")
    private Date stateDate;

    public static class Builder {

        private TagDto instance = new TagDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addName(String name) {
            this.instance.setName(name);
            return this;
        }

        public Builder addCreateDate(Date createDate) {
            this.instance.setCreateDate(createDate);
            return this;
        }

        public Builder addState(EnumTagState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addStateDate(Date stateDate) {
            this.instance.setStateDate(stateDate);
            return this;
        }

        public TagDto build() {
            return this.instance;
        }
    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public EnumTagState getState() {
        return state;
    }

    public void setState(EnumTagState state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createDate=").append(createDate);
        sb.append(", state=").append(state);
        sb.append(", stateDate=").append(stateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}