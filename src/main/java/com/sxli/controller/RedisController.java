package com.sxli.controller;

import com.sxli.pool.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisPool redisPool;

    @RequestMapping("/save")
    public String save(){
        Jedis jedis = redisPool.getJedis();
        return jedis.set("message","hello redis!");
    }
}
