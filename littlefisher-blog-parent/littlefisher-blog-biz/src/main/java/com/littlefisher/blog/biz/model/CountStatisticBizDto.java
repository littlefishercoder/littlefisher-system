package com.littlefisher.blog.biz.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumCountStatisticState;
import com.littlefisher.blog.common.enums.EnumCountStatisticType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author jinyn22648
 * @version $$Id: CountStatisticBizDto.java, v 0.1 2018/3/27 下午7:31 jinyn22648 Exp $$
 */
@ApiModel("统计")
public class CountStatisticBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2832281114486458934L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 作者id
     */
    @ApiModelProperty("作者id")
    private Long authorId;

    /**
     * 统计类型
     */
    @ApiModelProperty("统计类型")
    private EnumCountStatisticType type;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private EnumCountStatisticState state;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateDate;

    public static final class Builder {

        private CountStatisticBizDto instance = new CountStatisticBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
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

        public CountStatisticBizDto build() {
            return this.instance;
        }
    }

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
        return "CountStatisticBizDto{" + "id=" + id + ", authorId=" + authorId + ", type=" + type + ", state=" + state
            + ", createDate=" + createDate + ", updateDate=" + updateDate + '}';
    }
}
