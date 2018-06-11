package com.jinstec.service;

import com.jinstec.entity.DataList;

import java.util.List;

/**
 * @author jins
 * @date on 2018/4/28.
 */
public interface DataListService {

    /**
     * 根据dataTypeCode 查询dataList
     * @param dataTypeCode
     * @return
     */
    List<DataList> selectByDataTypeCode(String dataTypeCode);
}
