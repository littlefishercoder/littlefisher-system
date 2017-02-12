package com.yc.room1000.jyn.test.dao;

import com.yc.room1000.core.mybatis.SuperMapper;
import com.yc.room1000.jyn.test.dto.RentalLeaseOrderDto;

public interface RentalLeaseOrderDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return int int<br>
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insert(RentalLeaseOrderDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(RentalLeaseOrderDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return RentalLeaseOrderDto RentalLeaseOrderDto<br>
     * @mbg.generated
     */
    RentalLeaseOrderDto selectByPrimaryKey(Long id);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RentalLeaseOrderDto record);

    /**
     * Description: updateByPrimaryKeyWithBLOBs<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(RentalLeaseOrderDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(RentalLeaseOrderDto record);
}