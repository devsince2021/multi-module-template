package com.iwsaitw.template.persistence.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;

@Import(PostgresqlConfig.class)
public class PostgresqlTestConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:55433/single_template_test")
                .username("user")
                .password("password")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
