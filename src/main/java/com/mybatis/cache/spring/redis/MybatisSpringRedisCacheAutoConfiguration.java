package com.mybatis.cache.spring.redis;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Log4j2
@Configuration
@ConditionalOnClass({RedisTemplate.class,SqlSession.class})
public class MybatisSpringRedisCacheAutoConfiguration {

    public MybatisSpringRedisCacheAutoConfiguration(){
        log.info(()->"Inject RestTemplate for the mybatis-spring-redis secondary cache.");
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<Object,Object> redisTemplate){
        RedisCache.setRedisTemplate(redisTemplate);
    }
}
