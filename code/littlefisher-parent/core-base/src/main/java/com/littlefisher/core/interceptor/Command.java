package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 * @param <U>
 */
public interface Command<U> {

    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param commandContext <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    U execute(CommandContext commandContext) throws BaseAppException;
    
    /**
     * object 实现toString()方法，将相应的属性值输出
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
//    List<Object> getInputArgs();
}
