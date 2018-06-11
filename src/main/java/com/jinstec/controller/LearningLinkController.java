package com.jinstec.controller;

import com.jinstec.core.support.Result;
import com.jinstec.entity.dto.LearningLinkDto;
import com.jinstec.service.LearningLinkService;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import com.jinstec.util.datatable.DataTableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jins
 * @date on 2018/4/28.
 */
@Api("学习链接页面")
@Controller
public class LearningLinkController extends BaseController {

    @Autowired
    private LearningLinkService learningLinkService;

    @ApiOperation(value = "获取单个类别展示")
    @GetMapping("/learning-links/list-display")
    @ResponseBody
    public String listShow(HttpServletRequest request){
        DataRequest dataRequest = params(request);
        DataResult dataResult = learningLinkService.selectByListData(dataRequest);
        return DataTableUtil.transToJsonStr(dataResult);
    }

    @ApiOperation(value = "新增或修改")
    @PostMapping("/learning-links")
    @ResponseBody
    public Result saveOrUpdate(LearningLinkDto dto){
        learningLinkService.saveOrUpdate(dto);
        return new Result();
    }

    @ApiOperation(value = "查询数据")
    @GetMapping("/learning-links/{id}")
    public String  findLearningLinkById(@PathVariable("id") String id, Model model){
        LearningLinkDto dto = learningLinkService.findByLearningLinkId(id);
        model.addAttribute("dto",dto);
        return "/learning-link/edit-page";
    }


}
