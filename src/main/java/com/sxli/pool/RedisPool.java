package com.sxli.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接池-单例
 * @author sxli
 *
 */
public class RedisPool {

    /**
     *读取config文件来建立线程池
     */
    @Autowired
    private Environment env;
    /**
     * redis连接池对象
     */
    private JedisPool pool = null;

    /**
     * 获取jedis实例对象，内部集成redis连接池获取jedis实例
     */
    public Jedis getJedis() {
        //判断连接池对象是否为空
        if(pool == null) {
            synchronized(RedisPool.class) {
                if(pool == null) {
                    /**
                     * redis连接池配置 可以配置连接池可以拥有多少jedis实例，允许同时存在多少个空闲jedis实例
                     */
                    JedisPoolConfig config = new JedisPoolConfig();
                    //设置连接池最多拥有多少实例
                    config.setMaxTotal(Integer.parseInt(env.getProperty("spring.redis.pool.max-active")));
                    //设置连接池最多拥有多少空闲jedis实例
                    config.setMaxIdle(Integer.parseInt(env.getProperty("spring.redis.pool.max-idle")));
                    //设置等待时间，超时会出现异常
                    config.setMaxWaitMillis(Long.parseLong(env.getProperty("spring.redis.timeout")));
                    //实例化jedis连接池
                    pool = new JedisPool(config,env.getProperty("spring.redis.host"),Integer.parseInt(env.getProperty("spring.redis.port")));
                }
            }
        }
        //从连接池获取jedis对象
        return pool.getResource();
    }

    /**
     * jedis实例回收，新版Jedis不用通过连接池去回收，jedis内部直接集成了以前pool回收的机制，直接jedis.close()即可
     */
    public void close(Jedis jedis) {
        if(jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {
                //打印异常信息
                e.printStackTrace();
                //释放资源
                if(jedis.isConnected()) {
                    jedis.quit();
                    jedis.disconnect();
                }
            }
            //判断是否释放资源
            if(jedis.isConnected()) {
                jedis.quit();
                jedis.disconnect();
            }
        }
    }
}