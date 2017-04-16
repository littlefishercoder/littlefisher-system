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
 */
public abstract class AbstractCommandInterceptor implements CommandInterceptor {

    /**
     * next
     */
    protected CommandInterceptor next;

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    @Override
    public CommandInterceptor getNext() {
        return next;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param next <br>
     */
    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }
}
