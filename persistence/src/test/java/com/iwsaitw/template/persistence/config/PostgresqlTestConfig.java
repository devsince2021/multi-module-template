package com.iwsaitw.template.persistence.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;

@Import(PostgresqlConfig.class)
public class PostgresqlTestConfig { }
