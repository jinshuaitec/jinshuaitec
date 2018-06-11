package com.jinstec.controller;

import com.jinstec.core.support.JSONResult;
import com.jinstec.core.support.Result;
import com.jinstec.entity.dto.SoftwareLinkDto;
import com.jinstec.service.SoftwareLinkService;
import com.jinstec.util.StringUtil;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import com.jinstec.util.datatable.DataTableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jins
 * @date on 2018/5/2.
 */
@Controller
public class SoftwareLinkController extends BaseController {

    @Autowired
    private SoftwareLinkService softwareLinkService;

    @ResponseBody
    @GetMapping(value = "/software-links/list-display")
    public String listDisplay(HttpServletRequest request){
        DataRequest dataRequest = params(request);
        DataResult dataResult = softwareLinkService.selectByListData(dataRequest);
        return DataTableUtil.transToJsonStr(dataResult);
    }

    @PostMapping(value = "/software-links")
    @ResponseBody
    public Result saveOrUpdate( SoftwareLinkDto softwareLinkDto){
        softwareLinkService.saveOrUpdate(softwareLinkDto);
        return new Result();
    }

    @GetMapping(value = "/software-links/{id}")
    @ResponseBody
    public JSONResult findSoftwareLinkByOne(@PathVariable("id") String id){
        return new JSONResult(softwareLinkService.findSoftwareLinkByOne(id));
    }
}
