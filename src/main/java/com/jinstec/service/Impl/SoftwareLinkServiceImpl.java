package com.jinstec.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jinstec.dao.SoftwareLinkMapper;
import com.jinstec.entity.SoftwareLink;
import com.jinstec.entity.dto.SoftwareLinkDto;
import com.jinstec.service.SoftwareLinkService;
import com.jinstec.util.StringUtil;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jins
 * @date on 2018/5/2.
 */
@Service("softwareLinkServiceImpl")
public class SoftwareLinkServiceImpl extends BaseServiceImpl<SoftwareLink> implements SoftwareLinkService {

    @Autowired
    private SoftwareLinkMapper softwareLinkMapper;

    @Override
    public DataResult selectByListData(DataRequest dataRequest) {
        Page<SoftwareLink> page = PageHelper.startPage(dataRequest.getPageIndex(),dataRequest.getPageSize());
        List<SoftwareLink> list = softwareLinkMapper.findAll(dataRequest.getParams());
        DataResult dataResult = new DataResult();
        dataResult.setiTotalRecords(page.getTotal());
        dataResult.setiTotalDisplayRecords(page.getTotal());
        dataResult.setAaData(list);
        return dataResult;
    }

    @Override
    public void saveOrUpdate(SoftwareLinkDto dto) {
        SoftwareLink softwareLink = null;
        if (StringUtil.isEmpty(dto.getId())){
            softwareLink = new SoftwareLink();
        }else {
            softwareLink = softwareLinkMapper.selectByPrimaryKey(dto.getId());
        }
        BeanUtils.copyProperties(dto,softwareLink);
        saveBasicInfo(softwareLink);
        softwareLinkMapper.insert(softwareLink);

    }

    @Override
    public SoftwareLinkDto findSoftwareLinkByOne(String id) {
        SoftwareLinkDto softwareLinkDto = new SoftwareLinkDto();
        SoftwareLink softwareLink = softwareLinkMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(softwareLink,softwareLinkDto);
        return softwareLinkDto;
    }
}
