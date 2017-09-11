package com.littlefisher.core.utils.db.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.utils.db.cmd.QryDBDateTimeCmd;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service("core.dbService")
public class DBServiceImpl extends ServiceImpl {

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return Date
     * @throws BaseAppException <br>
     */
    public Date getDBDateTime() throws BaseAppException {
        return this.execute(new QryDBDateTimeCmd());

    }
}
