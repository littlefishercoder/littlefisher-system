package com.littlefisher.user.dal.param;

import java.io.Serializable;

/**
 *
 * @author jinyn22648
 * @version $$Id: SelectSystemParam4PageByCondParam.java, v 0.1 2018/3/26 下午4:47 jinyn22648 Exp $$
 */
public class SelectSystemParam4PageByCondParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7578150682768562517L;

    /**
     * id 主键id
     */
    private Long id;

    /**
     * paramKey 参数key 模糊查询
     */
    private String paramKey;

    /**
     * paramValue 参数value 模糊查询
     */
    private String paramValue;

    /**
     * defaultValue 参数默认value 模糊查询
     */
    private String defaultValue;

    public static class Builder {

        private SelectSystemParam4PageByCondParam instance = new SelectSystemParam4PageByCondParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addParamKey(String paramKey) {
            this.instance.setParamKey(paramKey);
            return this;
        }

        public Builder addParamValue(String paramValue) {
            this.instance.setParamValue(paramValue);
            return this;
        }

        public Builder addDefaultValue(String defaultValue) {
            this.instance.setDefaultValue(defaultValue);
            return this;
        }

        public SelectSystemParam4PageByCondParam build() {
            return this.instance;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "SelectSystemParam4PageByCondParam{" + "id=" + id + ", paramKey='" + paramKey + '\'' +
                ", paramValue='" + paramValue + '\'' + ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
