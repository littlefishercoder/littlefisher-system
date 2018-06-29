package com.littlefisher.user.biz.converter;

import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.dal.model.SystemParamDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: SystemParamDtoConverter.java, v 0.1 2018/3/26 下午7:54 jinyn22648 Exp $$
 */
public final class SystemParamDtoConverter {

    /**
     * 私有构造函数
     */
    private SystemParamDtoConverter() {
    }

    /**
     * SystemParamBizDto转SystemParamDto
     * 
     * @param systemParamBizDto SystemParamBizDto
     * @return SystemParamDto
     */
    public static SystemParamDto converterSystemParamDto(SystemParamBizDto systemParamBizDto) {
        return SystemParamDto.Builder.getInstance().addParamKey(systemParamBizDto.getParamKey())
            .addParamValue(systemParamBizDto.getParamValue()).addDefaultValue(systemParamBizDto.getDefaultValue())
            .addParamDesc(systemParamBizDto.getParamDesc()).build();
    }

    /**
     * SystemParamDto转SystemParamBizDto
     * 
     * @param systemParamDto SystemParamDto
     * @return SystemParamBizDto
     */
    public static SystemParamBizDto converterSystemParamBizDto(SystemParamDto systemParamDto) {
        return SystemParamBizDto.Builder.getInstance().addId(systemParamDto.getId())
            .addParamKey(systemParamDto.getParamKey()).addParamValue(systemParamDto.getParamValue())
            .addDefaultValue(systemParamDto.getDefaultValue()).addParamDesc(systemParamDto.getParamDesc()).build();
    }
}
