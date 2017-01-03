package com.yc.core.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yc.core.exception.log.utils.ExceptionUtil;
import com.yc.core.utils.ListUtil;
import com.yc.core.utils.Room1000Logger;

/**
 * 
 * Description: BaseAppException
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class BaseAppException extends Exception {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = 3908474026331716374L;
    
    /** LOGGER */
    private static final Room1000Logger LOGGER = Room1000Logger.getLogger(BaseAppException.class);

    /** id */
    private int id;

    /** code */
    private String code;

    /** desc */
    private String desc;

    /** localeMessage */
    private String localeMessage;

    /** time */
    private Date time;

    /** type */
    private int type;
    
    /**
     * 为了可对异常信息进行参数替换，扩展了String arg0,String arg1,String arg2 三个参数
     * 
     * @param errorCode String
     * @param message String
     * @param errorType int
     * @param cause Throwable
     * @param arg0 String
     * @param arg1 String
     * @param arg2 String
     */
    public BaseAppException(String errorCode, String message, int errorType, Throwable cause, String arg0, String arg1,
        String arg2) {
        
        super(message, cause);

        List<String> list = new ArrayList<String>(3);
        
        if (arg0 != null) {
            list.add(arg0);
        }
        if (arg1 != null) {
            list.add(arg1);
        }
        if (arg2 != null) {
            list.add(arg2);
        }
        String[] args = null;

        if (ListUtil.isNotEmpty(list)) {
            args = new String[list.size()];
            int i = 0;
            for (String s : list) {
                args[i++] = s;
            }
        }

        this.code = errorCode;
        this.desc = message;
        BaseAppException beCause = ExceptionUtil.getFirstBaseAppException(cause);
        if (beCause == null) {
            this.type = errorType;
        }
        else {
            this.type = beCause.getType();
        }

        try {
            //this.localeMessage = (code == null ? "" : MessageSource.getText(code));
            this.localeMessage = (code == null ? "" : code);

            if (args != null && args.length > 0) {
                this.localeMessage = this.replaceArgs(localeMessage, args);
            }
        }
        catch (Exception ex) {
            LOGGER.error(ex.getLocalizedMessage());
//            ex.printStackTrace();
        }
    }
    
    /**
     * 占位符替换
     * 
     * @param s s
     * @param args args 
     * @return String
     */
    private String replaceArgs(String s, String args[]) {
        int i = 0;
        if (s != null && args != null && args.length > 0) {
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile("\\{(.*?)\\}");
            Matcher m = p.matcher(s);
            while (m.find()) {
                s = s.replaceFirst("\\{(.*?)\\}", args[i++]);
            }
            sb.append(s);
            return sb.toString();
        }

        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocaleMessage() {
        return localeMessage;
    }

    public void setLocaleMessage(String localeMessage) {
        this.localeMessage = localeMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
