package com.littlefisher.core.biz.framework.cmd.system;

import com.littlefisher.core.i18n.PropResource;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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

    @Override
    public Void execute() {
        PropResource.init();
        return null;
    }
}
