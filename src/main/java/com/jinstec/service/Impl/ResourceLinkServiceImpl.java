package com.jinstec.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinstec.dao.ResourceLinkMapper;
import com.jinstec.entity.ResourceLink;
import com.jinstec.entity.dto.ResourceLinkDto;
import com.jinstec.service.ResourceLinkService;
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
 * @date on 2018/5/2.
 */
@Service("resourceLinkServiceImpl")
@Transactional
public class ResourceLinkServiceImpl extends BaseServiceImpl<ResourceLink> implements ResourceLinkService {

    @Autowired
    private ResourceLinkMapper resourceLinkMapper;

    @Override
    public DataResult selectByListData(DataRequest dataRequest) {
        Page<ResourceLink> page = PageHelper.startPage(dataRequest.getPageIndex(),dataRequest.getPageSize());
        List<ResourceLink> list = resourceLinkMapper.findAll(dataRequest.getParams());
        DataResult dataResult = new DataResult();
        dataResult.setAaData(list);
        dataResult.setiTotalDisplayRecords(page.getTotal());
        dataResult.setiTotalRecords(page.getTotal());
        return dataResult;
    }

    @Override
    public ResourceLinkDto findResourceLinkByOne(String id) {
        ResourceLink resourceLink = resourceLinkMapper.selectByPrimaryKey(id);
        ResourceLinkDto resourceLinkDto = new ResourceLinkDto();
        BeanUtils.copyProperties(resourceLink,resourceLinkDto);
        return resourceLinkDto;
    }

    @Override
    public void saveOrUpdate(ResourceLinkDto resourceLinkDto) {
        boolean judge = false;
        ResourceLink resourceLink = null;
        if (StringUtil.isEmpty(resourceLinkDto.getId())){
            resourceLink = new ResourceLink();
        }else {
            resourceLink = resourceLinkMapper.selectByPrimaryKey(resourceLinkDto.getId());
            judge = true;
        }
        BeanUtils.copyProperties(resourceLinkDto,resourceLink);
        saveBasicInfo(resourceLink);
        if (judge){
            resourceLinkMapper.updateByPrimaryKey(resourceLink);
        }else {
            resourceLinkMapper.insert(resourceLink);
        }
    }
}
