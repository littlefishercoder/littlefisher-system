package com.littlefisher.user.cmd.system;

import com.google.common.collect.Maps;
import com.littlefisher.core.i18n.PropResource;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Properties;

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
public class GetResourceCmd extends AbstractCommand<HashMap<Object,Object>> {

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
