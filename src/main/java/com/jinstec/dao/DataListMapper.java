package com.jinstec.dao;

import com.jinstec.entity.DataList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataListMapper extends BaseMapper<DataList> {

    /**
     * 根据dataTypeCode 查询dataList
     * @param dataTypeCode
     * @return
     */
    List<DataList> selectByDataTypeCode(String dataTypeCode);

}