package com.sxli.controller;

import com.sxli.pool.RedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisPool redisPool;

    @RequestMapping("/save/{key}/{value}")
    public String save(@PathVariable("key") String key,@PathVariable("value") String value){
        Jedis jedis = redisPool.getJedis();
        String result = jedis.set(key,value);
        redisPool.close(jedis);
        return result;
    }

    @RequestMapping("/find/{key}")
    public String find(@PathVariable("key") String key){
        Jedis jedis = redisPool.getJedis();
        String value = jedis.get(key);
        redisPool.close(jedis);
        return value;
    }
}
