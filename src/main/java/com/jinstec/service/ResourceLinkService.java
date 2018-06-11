package com.jinstec.service;

import com.jinstec.entity.dto.ResourceLinkDto;
import com.jinstec.entity.dto.SoftwareLinkDto;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;

/**
 * @author jins
 * @date on 2018/5/2.
 */
public interface ResourceLinkService {

    /**
     * 查询列表数据
     * @param dataRequest
     * @return
     */
    DataResult selectByListData(DataRequest dataRequest);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    ResourceLinkDto findResourceLinkByOne(String id);

    /**
     * 新增或修改
     * @param resourceLinkDto
     */
    void saveOrUpdate(ResourceLinkDto resourceLinkDto);

}
