package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.config.PostgresqlTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes = PostgresqlTestConfig.class)
public class SampleRepositoryImplTest {

    @Test
    public void contextLoads() {}
}
