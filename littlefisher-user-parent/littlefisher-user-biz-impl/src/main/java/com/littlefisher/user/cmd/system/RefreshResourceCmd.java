package com.littlefisher.user.cmd.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.common.i18n.PropResource;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

/**
 * Description: RefreshResourceCmd.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class RefreshResourceCmd extends AbstractCommand<Void> {

    @Autowired
    private PropResource propResource;

    @Override
    public Void execute() {
        propResource.init();
        return null;
    }
}
