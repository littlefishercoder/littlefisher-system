package com.yc.room1000.core.utils.db.cmd;

import java.util.Date;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.AbstractCommand;
import com.yc.room1000.core.interceptor.Command;
import com.yc.room1000.core.utils.db.dao.DBMapper;

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
public class QryDBDateTimeCmd extends AbstractCommand implements Command {

//    @Override
//    public List<Object> getInputArgs() {
//        return null;
//    }

    @Override
    public Date execute() throws BaseAppException {
        DBMapper dbMapper = this.getMapper(DBMapper.class);
        Date date = dbMapper.getDBDateTime();
        return date;
    }

}
