package com.littlefisher.blog.dal.param;

import java.io.Serializable;

/**
 *
 * @author jinyn22648
 * @version $$Id: SelectTag4PageByCondParam.java, v 0.1 2018/3/27 下午8:57 jinyn22648 Exp $$
 */
public class SelectTag4PageByCondParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -9151726464061861688L;

    public static final class Builder {

        private SelectTag4PageByCondParam instance = new SelectTag4PageByCondParam();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public SelectTag4PageByCondParam build() {
            return this.instance;
        }
    }
}
