package com.jinstec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jins
 * @date on 2018/4/28.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/{path}")
    public String statisticalDataPage(@PathVariable String path){
        return path;
    }

    @GetMapping("/{page}/{edit}")
    public String editPage(@PathVariable String page,@PathVariable String edit){
        return page+"/"+edit;
    }
}
