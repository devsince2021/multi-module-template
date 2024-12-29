package com.iwsaitw.base.persistence.base.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import(BaseEntityConfig.class)
@EnableJpaRepositories(basePackages = "com.iwsaitw.base.persistence.base.config")
@EntityScan(basePackages = "com.iwsaitw.base.persistence.base.config")
public class BaseEntityTestConfig { }
