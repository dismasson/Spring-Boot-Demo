package com.sxli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBootApplication作用等同于 Configuration + EnbaleAutoConfiguration + ComponentScan
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication {

    public static void main(String[] arg){
        SpringApplication.run(DemoApplication.class,arg);
    }

}
