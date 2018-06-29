package com.littlefisher.user.biz.cmd.system;

import java.util.HashMap;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.littlefisher.core.common.i18n.PropResource;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

/**
 * Description: GetResourceCmd.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetResourceCmd extends AbstractCommand<HashMap<Object, Object>> {

    /** 方言 */
    private String dialect;

    @Autowired
    private PropResource propResource;

    public GetResourceCmd setDialect(String dialect) {
        this.dialect = dialect;
        return this;
    }

    @Override
    public HashMap<Object, Object> execute() {
        Properties properties = propResource.getResource(dialect);
        return Maps.newHashMap(properties);
    }
}
