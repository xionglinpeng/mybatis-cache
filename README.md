# Mybatis Cache
## 前言
之所以开发这个项目，是因为在使用Mybatis二级缓存的时候没有找到一个开源的优秀的Mybatis
第三方缓存存储库集成的软件，特别是与Spring的集成。虽然MyBatis官方提供了一个与Redis集成的应用，
但是它是一个单独的，没有与Spring完美集成的应用，单独封装了套jedis操作。所以诞生了开发这样一个开源软件。

mybatis集成Redis的官方Maven依赖（它是一个beta版本）
```xml
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-redis</artifactId>
    <version>1.0.0-beta2</version>
</dependency>

```

## Mybatis Spring Redis Cache
开启Mybatis应用的Spring Redis的二级缓存，有如下三种方式：
1. Enable启动
    ```java
    @EnableMybatisSpringRedisCache
    ```
2. 包扫描
    ```java
    @ComponentScan("com.mybatis.cache.spring.redis")
    ```
3. 依赖注入
    ```java
    @Autowired
    public void setRedisTemplate(RedisTemplate<Object,Object> redisTemplate){
        RedisCache.setRedisTemplate(redisTemplate);
    }
    ```
## 测试数据库
见源码`src/test/resources/user.sql`

## Mybatis配置
开启完成之后即可在Mybatis上应用二级缓存，如下接口方式和XML配置方式：
- XML
    ```xml
    <cache type="com.mybatis.cache.spring.redis.RedisCache"/>
    ```
- interface
    ```java
    import com.mybatis.cache.spring.redis.RedisCache;
    import org.apache.ibatis.annotations.CacheNamespace;
    
    @CacheNamespace(implementation = RedisCache.class)
    public interface Mapper {
        ...
    }
    ```