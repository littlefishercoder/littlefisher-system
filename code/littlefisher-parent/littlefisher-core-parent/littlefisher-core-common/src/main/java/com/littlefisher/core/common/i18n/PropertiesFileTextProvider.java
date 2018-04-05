package com.littlefisher.core.common.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.littlefisher.core.common.stereotype.constants.BaseConstants;

/**
 * 
 * Description: 消息提供者实现类
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
public class PropertiesFileTextProvider implements TextProvider {

    @Autowired
    private PropResource propResource;

    @Override
    public String getText(String key) {
        return this.getText(BaseConstants.DIALECT_DEFAULT, key);
    }

    @Override
    public String getText(String dialect, String key) {
        return propResource.getValue(dialect, key);
    }

}
