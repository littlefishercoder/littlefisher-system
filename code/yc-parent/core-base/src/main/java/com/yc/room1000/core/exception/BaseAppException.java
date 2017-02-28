package com.yc.room1000.core.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yc.room1000.core.i18n.PropertiesFileTextProvider;
import com.yc.room1000.core.i18n.TextProvider;
import com.yc.room1000.core.utils.ListUtil;
import com.yc.room1000.core.utils.StringUtil;

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
    
    /** textProvider */
    private static TextProvider textProvider = new PropertiesFileTextProvider();

    /** 资源文件中的key值 */
    private String code;

    /** 异常描述 */
    private String desc;

    /** 资源文件中的value值，如果有占位符，也已被替换 */
    private String localeMessage;

    /**
     * 为了可对异常信息进行参数替换，扩展了String arg0,String arg1,String arg2 三个参数
     * 
     * @param errorCode String
     * @param message String
     * @param cause Throwable
     * @param arg0 String
     * @param arg1 String
     * @param arg2 String
     */
    public BaseAppException(String errorCode, String message, Throwable cause, String arg0, String arg1, String arg2) {
        
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

        this.localeMessage = (code == null ? "" : textProvider.getText(code));
        
        this.localeMessage = StringUtil.isEmpty(this.localeMessage) ? message : this.localeMessage;

        if (args != null && args.length > 0) {
            this.localeMessage = this.replaceArgs(localeMessage, args);
        }
    }
    
    /**
     * 
     * BaseAppException
     * 
     * @param errorCode errorCode
     */
    public BaseAppException(String errorCode) {
        this(errorCode, null, null, null, null, null);  
    }
    
    /**
     * BaseAppException
     * 
     * @param errorCode errorCode
     * @param message message
     */
    public BaseAppException(String errorCode, String message) {
        this(errorCode, message, null, null, null, null);
    }

    /**
     * 
     * BaseAppException
     * 
     * @param errorCode errorCode
     * @param ex ex
     */
    public BaseAppException(String errorCode, Exception ex) {
        this(errorCode, null, ex, null, null, null);
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
}
