package com.jinstec.controller;

import com.jinstec.core.support.JSONResult;
import com.jinstec.service.DataListService;
import com.jinstec.util.datatable.DataRequest;
import com.jinstec.util.datatable.DataResult;
import com.jinstec.util.datatable.DataTableUtil;
import com.jinstec.wechat.AccessTokenApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jins
 * @date on 2018/5/27.
 */
@Api(description = "测试数据")
@RestController
@RequestMapping("/view-data")
public class TestController {

    @Autowired
    private DataListService dataListService;

    @ApiOperation(value = "获取datalist数据")
    @GetMapping("/data")
    @ResponseBody
    public JSONResult dataShow(String code){
        return new JSONResult(dataListService.selectByDataTypeCode(code));
    }

    @ApiOperation(value = "测试accessToken")
    @GetMapping("/access-token")
    @ResponseBody
    public JSONResult dataShow(){
        return new JSONResult(AccessTokenApi.getAccessToken());
    }

}
