package com.yc.room1000.core.interceptor;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.context.Context;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LogInterceptor extends AbstractCommandInterceptor {

    /**
     * log
     */
    private static Room1000Logger log = Room1000Logger.getLogger(LogInterceptor.class);

    /**
     * Description: <br>
     * 
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    public Object execute(CommandConfig config, Command command) throws BaseAppException {
        
//        if (!log.isDebugEnabled()) {
//            // do nothing here if we cannot log
//            return next.execute(config, command);
//        }
        

        List<Object> inputArgs = command.getInputArgs();
        StringBuffer inputArgsStr = new StringBuffer();
        if (inputArgs != null) {
            for (int i = 0; i < inputArgs.size(); i++) {
                Object args = (Object) inputArgs.get(i);
                inputArgsStr.append("args[" + i + "]:").append(args == null ? "" : args.toString() + "\t");
            }
        }
        int levelSize = Context.getCommandContextStackSize();
        StringBuffer sb = new StringBuffer();
        sb.append("[").append(levelSize).append("]");
        for (int i = 0; i < levelSize; i++) {
            sb.append("--");
        }
        sb.append(">");
        
        log.info("{}starting {}, inputParam is {} ", 
            sb.toString(),
            command.getClass().getSimpleName(), inputArgsStr.toString());
        Object retnObj = null;
        try {

            retnObj = next.execute(config, command);
            return retnObj;

        }
        finally {
            log.info("{}{} finished . return object is {}", sb.toString(),
                command.getClass().getSimpleName(), retnObj == null ? "null" : retnObj.toString());
            
        }
    }
}
