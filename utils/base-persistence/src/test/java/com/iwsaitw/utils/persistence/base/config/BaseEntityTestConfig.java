package com.iwsaitw.utils.persistence.base.config;

import com.iwsaitw.utils.persistence.config.BaseEntityConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Import(BaseEntityConfig.class)
@EnableJpaRepositories(basePackages = "com.iwsaitw.utils.persistence.base.config")
@EntityScan(basePackages = "com.iwsaitw.utils.persistence.base.config")
public class BaseEntityTestConfig { }
