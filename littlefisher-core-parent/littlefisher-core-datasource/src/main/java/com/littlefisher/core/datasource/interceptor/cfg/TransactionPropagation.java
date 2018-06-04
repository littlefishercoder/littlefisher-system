package com.littlefisher.core.datasource.interceptor.cfg;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public enum TransactionPropagation {

    /** REQUIRED */
    REQUIRED,
    /** REQUIRES_NEW */
    REQUIRES_NEW,
    /** NOT_SUPPORTED */
    NOT_SUPPORTED,
}
