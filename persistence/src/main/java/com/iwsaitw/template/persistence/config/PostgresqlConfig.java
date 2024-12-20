package com.iwsaitw.template.persistence.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.iwsaitw.template.persistence"})
@EntityScan(basePackages = {"com.iwsaitw.template.persistence"})
public class PostgresqlConfig { }
