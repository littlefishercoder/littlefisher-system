package com.yc.room1000.core.interceptor;

import com.yc.room1000.core.exception.BaseAppException;

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
public interface Command {

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandContext <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    Object execute(CommandContext commandContext) throws BaseAppException;
    
    /**
     * object 实现toString()方法，将相应的属性值输出
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
//    List<Object> getInputArgs();
}
