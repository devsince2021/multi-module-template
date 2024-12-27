package com.iwsaitw.utils.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Import(BaseEntityConfig.class)
@EnableJpaRepositories(basePackages = "com.iwsaitw.utils.persistence.fixture")
@EntityScan(basePackages = "com.iwsaitw.utils.persistence.fixture")
public class BaseEntityTestConfig { }
