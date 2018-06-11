package com.jinstec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jins
 * @date on 2018/4/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              @RequestParam(value = "expired",required = false) String expired){
        ModelAndView model = new ModelAndView();
        if (error != null){
            model.addObject("msg","用户名密码失败");
        }
        if (logout != null){
            model.addObject("msg","成功退出");
        }
        if (expired != null){
            model.addObject("msg","当前账号已被他们登录或者登录超时");
        }
        model.setViewName("login");
        return model;
    }

    @GetMapping(value = "/index")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
