package com.littlefisher.core.springmvc;

import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.google.common.collect.Lists;
import com.littlefisher.core.utils.DateUtil;
import com.littlefisher.core.utils.ExceptionHandler;
import com.littlefisher.core.utils.StringUtil;

/**
 * Description: 自定义日期转换类
 *
 * Created on 2017年07月13日
 *
 * @author jinyanan
 * @version v1.0
 * @since v1.0
 */
public class DateConverter implements Converter<String, Date> {

    /**
     * formarts
     */
    private static final List<String> FORMATS = Lists.newArrayListWithCapacity(4);

    static {
        FORMATS.add("yyyy-MM");
        FORMATS.add("yyyy-MM-dd");
        FORMATS.add("yyyy-MM-dd hh:mm");
        FORMATS.add("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {

        if (StringUtil.isEmpty(source)) {
            return null;
        }

        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return DateUtil.string2Date(source, FORMATS.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return DateUtil.string2Date(source, FORMATS.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return DateUtil.string2Date(source, FORMATS.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return DateUtil.string2Date(source, FORMATS.get(3));
        } else {
            ExceptionHandler.publish("CORE-000008", null, source);
        }
        return null;
    }
}
