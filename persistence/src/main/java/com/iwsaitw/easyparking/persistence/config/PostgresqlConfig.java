package com.iwsaitw.easyparking.persistence.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.iwsaitw.easyparking"})
@EntityScan(basePackages = {"com.iwsaitw.easyparking"})
public class PostgresqlConfig { }
