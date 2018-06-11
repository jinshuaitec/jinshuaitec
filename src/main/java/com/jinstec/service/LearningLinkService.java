package com.jinstec.service;

import com.jinstec.entity.dto.LearningLinkDto;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;

/**
 * @author jins
 * @date on 2018/4/28.
 */
public interface LearningLinkService {

    /**
     * 根据不同的code显示不同的文章
     * @return
     */
    DataResult selectByListData(DataRequest dataRequest);

    /**
     * 保存和修改信息
     * @param dto
     */
    void saveOrUpdate(LearningLinkDto dto);

    /**
     * 根据id查询学习链接
     * @param id
     * @return
     */
    LearningLinkDto findByLearningLinkId(String id);



}
