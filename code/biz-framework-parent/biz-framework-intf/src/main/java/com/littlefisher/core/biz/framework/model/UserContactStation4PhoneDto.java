package com.littlefisher.core.biz.framework.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.core.biz.framework.enums.EnumUserContactStation4PhoneType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: bfm_user_contact_station_4_phone 实体
 *
 * Created on 2017年12月28日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "bfm_user_contact_station_4_phone")
@ApiModel("bfm_user_contact_station_4_phone实体")
public class UserContactStation4PhoneDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 联系点主键
     */
    @ApiModelProperty("联系点主键")
    @Id
    @Column(name = "contact_station_id")
    private Long contactStationId;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private EnumUserContactStation4PhoneType type;

    /**
     * 区号
     */
    @ApiModelProperty("区号")
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @Column(name = "phone_nbr")
    private String phoneNbr;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "update_date")
    private Date updateDate;

    public Long getContactStationId() {
        return contactStationId;
    }

    public void setContactStationId(Long contactStationId) {
        this.contactStationId = contactStationId;
    }

    public EnumUserContactStation4PhoneType getType() {
        return type;
    }

    public void setType(EnumUserContactStation4PhoneType type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
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
        sb.append(", contactStationId=").append(contactStationId);
        sb.append(", type=").append(type);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", phoneNbr=").append(phoneNbr);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}