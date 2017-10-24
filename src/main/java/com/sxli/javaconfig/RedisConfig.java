package com.sxli.javaconfig;

import com.sxli.pool.RedisPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean
    public RedisPool redisPool(){
        return new RedisPool();
    }
}
