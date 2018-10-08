package com.mybatis.cache.spring.redis;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Cache adapter for Redis.
 * @author 熊林鹏
 */
public class RedisCache implements Cache {

    private static RedisTemplate<Object,Object> redisTemplate;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public static void setRedisTemplate(RedisTemplate<Object, Object> rt) {
        redisTemplate = rt;
    }

    public RedisCache(final String id) {
        if (id == null)
            throw new IllegalArgumentException("Cache instances require an ID");
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        redisTemplate.opsForHash().put(this.id,key,value);
    }

    @Override
    public Object getObject(Object key) {
        return redisTemplate.opsForHash().get(this.id,key);
    }

    @Override
    public Object removeObject(Object key) {
        return redisTemplate.opsForHash().delete(this.id,key);
    }

    @Override
    public void clear() {
        redisTemplate.opsForHash().delete(this.id);
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().entries(this.id).size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    @Override
    public String toString() {
        return "Redis {" + id + "}";
    }
}
