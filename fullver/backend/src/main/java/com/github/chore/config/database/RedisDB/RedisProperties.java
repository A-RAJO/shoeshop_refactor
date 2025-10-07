package com.github.chore.config.database.RedisDB;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "datasource.redis")
@EnableCaching
public class RedisProperties {
    private String host;
    private int port;
    private String password;
}

