package com.sxli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
    开始 controller
 */
@RestController
public class IndexController {

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String index(){
        return "Hello SpringBoot!";
    }

}
