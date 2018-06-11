package com.jinstec.service.Impl;

import com.jinstec.dao.DataListMapper;
import com.jinstec.entity.DataList;
import com.jinstec.service.DataListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jins
 * @date on 2018/4/28.
 */
@Service("dataListServiceImpl")
public class DataListServiceImpl implements DataListService {

    @Autowired
    private DataListMapper dataListMapper;

    @Override
    public List<DataList> selectByDataTypeCode(String dataTypeCode) {
        return dataListMapper.selectByDataTypeCode(dataTypeCode);
    }
}
