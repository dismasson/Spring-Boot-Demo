package com.sxli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class LogController {

    private static Logger log = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/save/info/{message}")
    public String infolog(@PathVariable("message") String message){
        log.info(message);
        return "ok";
    }

    @RequestMapping("/save/error/{message}")
    public String errorlog(@PathVariable("message") String message){
        log.error(message);
        return "ok";
    }

}
