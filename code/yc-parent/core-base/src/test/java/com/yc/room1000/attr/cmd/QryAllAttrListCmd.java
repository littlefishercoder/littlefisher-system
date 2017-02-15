package com.yc.room1000.attr.cmd;

import java.io.Serializable;
import java.util.List;

import com.yc.room1000.attr.dto.AttrDto;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAllAttrListCmd extends AbstractCommand implements Command, Serializable  {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 1972204650503671615L;

    @Override
    public List<AttrDto> execute() throws BaseAppException {
        return null;
    }

    @Override
    public List<Object> getInputArgs() {
        return null;
    }

}
