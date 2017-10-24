package com.sxli.javaconfig;

import com.sxli.dao.SpringUserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public SpringUserDao userDao(){
        return new SpringUserDao();
    }

}
