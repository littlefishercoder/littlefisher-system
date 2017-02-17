package com.yc.room1000.core.utils.db.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;
import com.yc.room1000.core.utils.db.cmd.QryDBDateTimeCmd;

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
@Service("CORE.DBService")
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
        return (Date) this.execute(new QryDBDateTimeCmd());

    }
}
