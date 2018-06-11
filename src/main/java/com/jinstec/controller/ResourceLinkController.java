package com.jinstec.controller;

import com.jinstec.core.support.JSONResult;
import com.jinstec.core.support.Result;
import com.jinstec.entity.dto.ResourceLinkDto;
import com.jinstec.service.ResourceLinkService;
import com.jinstec.util.StringUtil;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import com.jinstec.util.datatable.DataTableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jins
 * @date on 2018/5/2.
 */
@Controller
public class ResourceLinkController extends BaseController {

    @Autowired
    private ResourceLinkService resourceLinkService;

    @GetMapping("/resource-link/list-display")
    @ResponseBody
    public String listDisplay(HttpServletRequest request){
        DataRequest dataRequest = params(request);
        DataResult dataResult = resourceLinkService.selectByListData(dataRequest);
        return DataTableUtil.transToJsonStr(dataResult);
    }

    @GetMapping("/resource-link/{id}")
    public String findResourceLinkByOne(@PathVariable("id") String id, Model model){
        ResourceLinkDto dto = resourceLinkService.findResourceLinkByOne(id);
        model.addAttribute("dto",dto);
        return "/resource-link/edit-page";
    }

    @ResponseBody
    @PostMapping("/resource-links")
    public Result saveOrUpdate( ResourceLinkDto resourceLinkDto){
        resourceLinkService.saveOrUpdate(resourceLinkDto);
        return new Result();
    }

}
