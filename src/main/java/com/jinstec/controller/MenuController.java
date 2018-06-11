package com.jinstec.controller;

import com.jinstec.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jins
 * @date on 2018/4/25.
 */
@Api("菜单管理")
@Controller
@RequestMapping(value = "/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取菜单数据")
    @RequestMapping(value = "/load-menu",method = RequestMethod.GET)
    @ResponseBody
    public String findAllMenu(){
        return menuService.findAllMenu();
    }

}
