package com.yc.core.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Description: 日志管理类 
 * 
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class Room1000Logger {
    
    /**
     * logger
     */
    protected Logger logger;

    /**
     * 将Log类封装成单实例的模式，独立于其他类。以后要用到日志的地方只要获得Log的实例就可以方便使用
     */
    private static Room1000Logger log;

    /**
     * 构造函数，用于初始化Logger配置需要的属性
     * @param logger logger
     */
    private Room1000Logger(Logger logger) {
        // 获得当前目录路径
        // String filePath=this.getClass().getResource("/").getPath();
        // 找到log4j.properties配置文件所在的目录(已经创建好)
        // filePath=filePath.substring(1).replace("bin", "src");
        // 获得日志类logger的实例
        // loger=Logger.getLogger(this.getClass());
        String ycHome = StringUtil.isNotEmpty(System.getenv("YC_HOME")) ? System.getenv("YC_HOME") : System.getProperty("YC_HOME");
        String filePath = ycHome + "/properties/log4j.properties";
        this.logger = logger;

        // logger所需的配置文件路径 D:\\publish2\\log4j.properties
        PropertyConfigurator.configureAndWatch(filePath);
    }

    /**
     * 获取构造器，根据类初始化Logger对象
     * 
     * @param clazz Class对象
     * @return Logger对象
     */
    public static Room1000Logger getLogger(Class<?> clazz) {
        if (log != null) {
            return log;
        }
        else {
            return new Room1000Logger(Logger.getLogger(clazz));
        }
    }

//    /**
//     * 
//     * Description:  该事件ID包含当前时间和主机IP,是标示日志时间的唯一符
//     * 
//     * @author jinyanan
//     *
//     * @return eventId
//     */
//    protected String eventId() {
//        // 获取当前时间
//        // 如果不需要格式,可直接用dt,dt就是当前系统时间
//        Date dt = new Date();
//        // 设置显示格式,24小时制
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String nowTime = df.format(dt); // 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
//
//        String nowIp;
//        try {
//            InetAddress addr = InetAddress.getLocalHost();
//            nowIp = addr.getHostAddress();
//        }
//        catch (Exception ex) {
//            nowIp = "";
//        }
//        nowTime = nowTime.replaceAll("/", "");
//        nowTime = nowTime.replaceAll(" ", "");
//        nowTime = nowTime.replaceAll(":", "");
//        nowIp = nowIp.replace(".", "");
//        String nowId = nowTime + nowIp;
//        return nowId;
//    }

    /**
     * 
     * Description:  debug
     * 
     * @author jinyanan
     *
     * @param content content
     */
    public void debug(String content) {
        if (logger.isDebugEnabled()) {
            logger.debug(content);
        }
    }
    
    /**
     * 
     * Description: debug
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void debug(Object msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }
    
    /**
     * 
     * Description: debug
     * 
     * @author jinyanan
     *
     * @param t t
     */
    public void debug(Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(t.getMessage(), t);
        }
    }

    /**
     * 
     * Description:  fatal
     * 
     * @author jinyanan
     *
     * @param content content
     */
    public void fatal(String content) {
        logger.fatal(content);
    }
    
    /**
     * 
     * Description: fatal
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void fatal(Object msg) {
        logger.fatal(msg);
    }
    
    /**
     * 
     * Description: fatal
     * 
     * @author jinyanan
     *
     * @param t t
     */
    public void fatal(Throwable t) {
        logger.fatal(t.getMessage(), t);
    }

    /**
     * 
     * Description:  info
     * 
     * @author jinyanan
     *
     * @param content content
     */
    public void info(String content) {
        if (logger.isInfoEnabled()) {
            logger.info(content);
        }
    }
    
    /**
     * 
     * Description: info
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void info(Object msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }
    
    /**
     * 
     * Description: info
     * 
     * @author jinyanan
     *
     * @param t t
     */
    public void info(Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(t.getMessage(), t);
        }
    }

    /**
     * 
     * Description:  warn
     * 
     * @author jinyanan
     *
     * @param content content
     */
    public void warn(String content) {
        logger.warn(content);
    }
    
    /**
     * 
     * Description: warn
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void warn(Object msg) {
        logger.warn(msg);
    }
    
    /**
     * 
     * Description: warn
     * 
     * @author jinyanan
     *
     * @param t t
     */
    public void warn(Throwable t) {
        logger.warn(t.getMessage(), t);
    }

    /**
     * 
     * Description:  error
     * 
     * @author jinyanan
     *
     * @param content content
     */
    public void error(String content) {
        logger.error(content);
    }
    
    /**
     * 
     * Description: error
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void error(Object msg) {
        logger.error(msg);
    }
    
    /**
     * 
     * Description: error
     * 
     * @author jinyanan
     *
     * @param t t
     */
    public void error(Throwable t) {
        logger.error(t.getMessage(), t);
    }
    
}
