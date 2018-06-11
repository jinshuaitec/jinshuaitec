package com.jinstec.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author jins
 * @date on 2018/4/28.
 */
@RestController
@RequestMapping("/statistical-data")
public class StatisticalDataController {



    @ApiOperation(value = "获取菜单数据")
    @GetMapping("/page")
    public String findAllMenu(){
        return null;
    }
}
