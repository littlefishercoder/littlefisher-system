package com.littlefisher.blog.biz.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumTagState;

/**
 *
 * @author jinyn22648
 * @version $$Id: TagBizDto.java, v 0.1 2018/3/23 下午12:37 jinyn22648 Exp $$
 */
public class TagBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 767090652350682754L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称(唯一)
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 状态
     */
    private EnumTagState state;

    /**
     * 状态变更时间
     */
    private Date stateDate;

    public static class Builder {

        private TagBizDto instance = new TagBizDto();

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

        public TagBizDto build() {
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
        return "TagBizDto{" + "id=" + id + ", name='" + name + '\'' + ", createDate=" + createDate + ", state=" + state
            + ", stateDate=" + stateDate + '}';
    }
}
