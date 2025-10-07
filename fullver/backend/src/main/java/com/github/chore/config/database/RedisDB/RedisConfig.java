package com.github.chore.config.database.RedisDB;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisConfig {

    @Bean
    @Qualifier("redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory(RedisProperties props) {
        LettuceConnectionFactory factory = new LettuceConnectionFactory(props.getHost(), props.getPort());
        factory.setPassword(props.getPassword());
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Qualifier("redisConnectionFactory") RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean
    public CacheManager cacheManager(@Qualifier("redisConnectionFactory") RedisConnectionFactory factory) {
        return RedisCacheManager.builder(factory).build();
    }
}