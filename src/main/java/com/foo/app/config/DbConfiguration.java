package com.foo.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DbConfiguration {


    @Bean
//    @Primary
    @ConfigurationProperties(prefix = "app.persons-ds.hikari")
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

}
