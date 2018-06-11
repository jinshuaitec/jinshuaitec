package com.jinstec.controller;

import com.jinstec.core.support.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jins
 * @date on 2018/4/16.
 */
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result saveUser(){
        return null;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result delete(){
        return null;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        return new Result();
    }

}
