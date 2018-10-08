package com.mybatis.cache.spring.redis;

import com.mybatis.cache.spring.redis.entity.User;
import com.mybatis.cache.spring.redis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.mybatis.cache.spring.redis.mapper")
@EnableMybatisSpringRedisCache
@SpringBootApplication
public class MybatisSpringRedisCacheApplicationTests {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringRedisCacheApplicationTests.class, args);
    }

    @Test
    public void contextLoads() {
        List<User> users =  userMapper.selectAll();
        users.forEach(System.out::println);
        userMapper.selectAll();
    }
}
