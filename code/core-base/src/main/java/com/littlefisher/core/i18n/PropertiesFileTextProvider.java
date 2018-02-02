package com.littlefisher.core.i18n;

import com.littlefisher.core.stereotype.constants.BaseConstants;

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
public class PropertiesFileTextProvider implements TextProvider {

    @Override
    public String getText(String key) {
        return this.getText(BaseConstants.DIALECT_DEFAULT, key);
    }

    @Override
    public String getText(String dialect, String key) {
        return PropResource.getValue(dialect, key);
    }

}
