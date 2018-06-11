package com.jinstec.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinstec.dao.LearningLinkMapper;
import com.jinstec.entity.LearningLink;
import com.jinstec.entity.dto.LearningLinkDto;
import com.jinstec.service.LearningLinkService;
import com.jinstec.util.StringUtil;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jins
 * @date on 2018/4/28.
 */
@Service("learningLinkServiceImpl")
@Transactional
public class LearningLinkServiceImpl extends BaseServiceImpl<LearningLink> implements LearningLinkService {

    @Autowired
    private LearningLinkMapper learningLinkMapper;

    @Override
    public DataResult selectByListData(DataRequest dataRequest) {
        DataResult data = new DataResult();
        Page<LearningLink> page = PageHelper.startPage(dataRequest.getPageIndex(),dataRequest.getPageSize());
        List list = learningLinkMapper.findAll(dataRequest.getParams());
        data.setiTotalRecords(page.getTotal());
        data.setiTotalDisplayRecords(page.getTotal());
        data.setAaData(list);
        return data;
    }

    @Override
    public void saveOrUpdate(LearningLinkDto dto) {
        boolean judge = false;
        LearningLink learningLink = null;
        if (StringUtil.isEmpty(dto.getId())){
            learningLink = new LearningLink();
        }else {
            learningLink = learningLinkMapper.selectByPrimaryKey(dto.getId());
            judge = true;
        }
        BeanUtils.copyProperties(dto,learningLink);
        saveBasicInfo(learningLink);
        if (judge){
            learningLinkMapper.updateByPrimaryKey(learningLink);
        }else {
            learningLinkMapper.insert(learningLink);
        }
    }

    @Override
    public LearningLinkDto findByLearningLinkId(String id) {
        LearningLinkDto learningLinkDto = new LearningLinkDto();
        LearningLink learningLink = learningLinkMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(learningLink,learningLinkDto);
        return learningLinkDto;
    }
}
