package com.littlefisher.user.cmd.system;

import com.littlefisher.core.i18n.PropResource;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import org.springframework.beans.factory.annotation.Autowired;

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
