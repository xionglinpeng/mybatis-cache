package com.mybatis.cache.spring.redis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String create_time;

}
