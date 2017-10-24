package com.sxli.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class SpringUserDao<SpringUserEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> getUser(String name){
        Object[] args = new Object[]{name};
        return jdbcTemplate.queryForMap("SELECT * FROM SPRING_USER WHERE NAME = ?",args);
    }
}
