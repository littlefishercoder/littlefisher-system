package com.littlefisher.core.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * Gson帮助类
 *
 * Created on 2017年10月5日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class GsonUtil {

    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd hh:mm:ss").create();

    /**
     * 禁止实例化
     */
    private GsonUtil() {}

    /**
     * 实体转json
     *
     * @param obj 要转的实体
     * @return String json
     */
    public static String obj2Json(Object obj) {
        return gson.toJson(obj);
    }
}
