package com.mybatis.cache.spring.redis.mapper;

import com.mybatis.cache.spring.redis.RedisCache;
import com.mybatis.cache.spring.redis.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@CacheNamespace(implementation = RedisCache.class)
public interface UserMapper {

    @Select("SELECT * FROM `user`")
    List<User> selectAll();
}
