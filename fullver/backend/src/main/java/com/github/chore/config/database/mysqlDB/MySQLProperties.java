package com.github.chore.config.database.mysqlDB;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "datasource.mysql")
public class MySQLProperties {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}