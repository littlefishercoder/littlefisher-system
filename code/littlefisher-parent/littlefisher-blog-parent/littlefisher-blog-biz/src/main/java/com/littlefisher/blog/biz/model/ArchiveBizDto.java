package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumArchiveState;

/**
 *
 * @author jinyn22648
 * @version $$Id: ArchiveBizDto.java, v 0.1 2018/3/23 下午12:33 jinyn22648 Exp $$
 */
@ApiModel("博文归档")
public class ArchiveBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 521043393637994573L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 分类名
     */
    @ApiModelProperty("分类名")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumArchiveState state;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    public static class Builder {

        private ArchiveBizDto instance = new ArchiveBizDto();

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

        public Builder addState(EnumArchiveState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public ArchiveBizDto build() {
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

    public EnumArchiveState getState() {
        return state;
    }

    public void setState(EnumArchiveState state) {
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
        return "ArchiveBizDto{" + "id=" + id + ", name='" + name + '\'' + ", state=" + state + ", updateDate="
            + updateDate + '}';
    }
}
