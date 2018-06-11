package com.jinstec.service;

import com.jinstec.entity.dto.SoftwareLinkDto;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;

/**
 * @author jins
 * @date on 2018/5/2.
 */
public interface SoftwareLinkService {

    /**
     * 查询列表数据
     * @param dataRequest
     * @return
     */
    DataResult selectByListData(DataRequest dataRequest);

    /**
     * 保存和修改数据
     * @param dto
     */
    void saveOrUpdate(SoftwareLinkDto dto);

    /**
     * 根据id查询软件链接
     * @param id
     * @return
     */
    SoftwareLinkDto findSoftwareLinkByOne(String id);
}
