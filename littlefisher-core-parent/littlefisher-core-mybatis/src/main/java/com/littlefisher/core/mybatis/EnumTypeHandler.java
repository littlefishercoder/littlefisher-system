package com.littlefisher.core.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.littlefisher.core.common.stereotype.enums.IEnum;

/**
 * Description: EnumTypeHandler.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@MappedTypes(IEnum.class)
public class EnumTypeHandler<E extends Enum<?> & IEnum> extends BaseTypeHandler<IEnum> {

    private Class<E> type;

    /**
     * 构造函数
     * 
     * @param type class类型
     */
    public EnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, IEnum parameter, JdbcType jdbcType)
        throws SQLException {
        if (jdbcType == null) {
            ps.setObject(i, parameter.getCode());
        } else {
            ps.setObject(i, parameter.getCode(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public IEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (null == rs.getString(columnName) && rs.wasNull()) {
            return null;
        }
        return valueOf(type, rs.getObject(columnName));
    }

    @Override
    public IEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (null == rs.getString(columnIndex) && rs.wasNull()) {
            return null;
        }
        return valueOf(type, rs.getObject(columnIndex));
    }

    @Override
    public IEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (null == cs.getString(columnIndex) && cs.wasNull()) {
            return null;
        }
        return valueOf(type, cs.getObject(columnIndex));
    }

    /**
     * 根据枚举class和code查找对应枚举值
     * 
     * @param enumClass 枚举class
     * @param value 枚举code
     * @param <E> 泛型
     * @return 枚举
     */
    private static <E extends Enum<?> & IEnum> E valueOf(Class<E> enumClass, Object value) {
        E[] es = enumClass.getEnumConstants();
        for (E e : es) {
            if (e.getCode() == value) {
                // 基本类型
                return e;
            } else if (value instanceof String && e.getCode().equals(value)) {
                // 字符串类型
                return e;
            } else if (String.valueOf(e.getCode()).equals(String.valueOf(value))) {
                // 其他类型
                return e;
            }
        }
        return null;
    }
}
