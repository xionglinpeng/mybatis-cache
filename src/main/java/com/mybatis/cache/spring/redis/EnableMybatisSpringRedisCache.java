package com.mybatis.cache.spring.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MybatisSpringRedisCacheAutoConfiguration.class})
public @interface EnableMybatisSpringRedisCache {
}
