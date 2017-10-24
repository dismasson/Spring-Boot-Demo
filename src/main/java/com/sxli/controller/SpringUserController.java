package com.sxli.controller;

import com.sxli.dao.SpringUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/springuser")
public class SpringUserController {

    @Autowired
    private SpringUserDao userDao;

    @RequestMapping("/getuser/{}")
    public Map<String,Object> getUser(@PathVariable("name") String name){
        return userDao.getUser(name);
    }

}
