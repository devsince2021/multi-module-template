package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.config.BasePersistenceTest;
import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleRepositoryImplTest extends BasePersistenceTest {

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        addSqlScript(registry, "sample-init.sql");
    }

    @Autowired
    private SampleJpaRepository sampleJpaRepository;

    @Test
    public void contextLoads() {
        Optional<SampleEntity> entity = sampleJpaRepository.findByName("WOW");
        assertTrue(entity.isPresent());

        Optional<SampleEntity> entity2 = sampleJpaRepository.findByName("OMG");
        assertFalse(entity2.isPresent());
    }
}
