package com.littlefisher.core.common.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.i18n.TextProvider;
import com.littlefisher.core.common.utils.SpringContextUtil;
import com.littlefisher.core.common.utils.StringUtil;

/**
 * Description: BaseAppException
 *
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class BaseAppException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3908474026331716374L;

    /** 资源文件中的key值 */
    private String code;

    /** 资源文件中的value值，如果有占位符，也已被替换 */
    private String localMessage;

    /** 大括号占位符占位符 */
    private static final String PLACEHOLDER_PATTERN = "\\{(.*?)}";

    /**
     * BaseAppException
     *
     * @param errorCode 异常码
     * @param message 异常信息
     * @param cause 异常
     * @param args 异常信息中的占位符的具体参数
     */
    public BaseAppException(String errorCode, String message, Throwable cause, String... args) {
        super(message, cause);

        args = Iterables.toArray(Iterables.filter(Lists.newArrayList(args), StringUtil::isNotBlank), String.class);

        this.code = errorCode;

        this.localMessage = StringUtil.isNotBlank(code) ? SpringContextUtil.getBean(TextProvider.class).getText(code)
            : StringUtil.EMPTY;

        this.localMessage = StringUtil.isNotEmpty(this.localMessage) ? this.localMessage : message;

        if (ArrayUtils.isNotEmpty(args)) {
            this.localMessage = this.replaceArgs(localMessage, args);
        }
    }

    /**
     * BaseAppException
     *
     * @param errorCode 异常码
     */
    public BaseAppException(String errorCode) {
        this(errorCode, null, null);
    }

    /**
     * BaseAppException
     *
     * @param errorCode 异常码
     * @param message 异常信息
     */
    public BaseAppException(String errorCode, String message) {
        this(errorCode, message, null);
    }

    /**
     * BaseAppException
     *
     * @param errorCode 异常码
     * @param ex 异常
     */
    public BaseAppException(String errorCode, Exception ex) {
        this(errorCode, null, ex);
    }

    /**
     * 占位符替换
     *
     * @param message 异常信息
     * @param args 替换参数
     * @return 替换后的信息
     */
    private String replaceArgs(String message, String[] args) {
        int i = 0;
        if (StringUtil.isNotBlank(message) && ArrayUtils.isNotEmpty(args)) {
            StringBuilder sb = new StringBuilder();
            Matcher matcher = Pattern.compile(PLACEHOLDER_PATTERN).matcher(message);
            while (matcher.find()) {
                message = message.replaceFirst(PLACEHOLDER_PATTERN, args[i++]);
            }
            sb.append(message);
            return sb.toString();
        }

        return StringUtil.EMPTY;
    }

    public String getCode() {
        return code;
    }

    public String getLocalMessage() {
        return localMessage;
    }

}
