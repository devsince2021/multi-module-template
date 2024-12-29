package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.config.DefaultPersistenceConfig;
import com.iwsaitw.template.persistence.entity.SampleEntity;
import com.iwsaitw.utils.persistence.export.testcontainer.BasePersistenceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = DefaultPersistenceConfig.class)
public class OtherSampleRepositoryImplTest extends BasePersistenceTest {

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        addSqlScript(registry, "sample2-init.sql");
    }

    @Autowired
    private SampleJpaRepository sampleJpaRepository;

    @Test
    public void contextLoads() {
        Optional<SampleEntity> entity = sampleJpaRepository.findByName("WOW");
        assertFalse(entity.isPresent());

        Optional<SampleEntity> entity2 = sampleJpaRepository.findByName("OMG");
        assertTrue(entity2.isPresent());
    }
}
