package com.sxli.config;

import com.sxli.pool.RedisPool;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    public RedisPool redisPool(){
        return new RedisPool();
    }
}
