package com.littlefisher.spring.boot.stereotype.enums;

/**
 * Description: EnumRegistryType
 *
 * Created on 2018年03月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum EnumRegistryType {

    /** zookeeper */
    ZOOKEEPER("zookeeper", "Zookeeper"),
    /** multicast */
    MULTICAST("multicast", "Multicast"),
    /** redis */
    REDIS("redis", "Redis"),
    /** simple */
    SIMPLE("redis", "Simple"),;

    /** 编码 */
    private String code;

    /** 描述 */
    private String description;

    EnumRegistryType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据code查找枚举
     * 
     * @param code 编码
     * @return 枚举
     */
    public EnumRegistryType find(String code) {
        for (EnumRegistryType enumRegistryType : EnumRegistryType.values()) {
            if (enumRegistryType.getCode().equals(code)) {
                return enumRegistryType;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
