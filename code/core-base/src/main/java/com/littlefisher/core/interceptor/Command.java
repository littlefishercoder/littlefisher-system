package com.littlefisher.core.interceptor;

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
     * 执行命令
     * @param commandContext 命令上下文
     * @return 命令返回值
     */
    U execute(CommandContext commandContext);
    
//    /**
//     * object 实现toString()方法，将相应的属性值输出
//     * Description: <br>
//     *
//     * @author jinyanan<br>
//     * @taskId <br>
//     * @return <br>
//     */
//    List<Object> getInputArgs();
}
