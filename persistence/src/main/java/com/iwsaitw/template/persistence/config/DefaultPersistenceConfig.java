package com.iwsaitw.template.persistence.config;

import com.iwsaitw.base.persistence.config.BaseEntityConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(BaseEntityConfig.class)
@EnableJpaRepositories(basePackages = {"com.iwsaitw.template.persistence"})
@EntityScan(basePackages = {"com.iwsaitw.template.persistence"})
public class DefaultPersistenceConfig { }
