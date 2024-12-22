package com.iwsaitw.template.persistence;

import com.iwsaitw.template.persistence.config.BasePersistenceTest;
import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_save_sample_with_id_and_createdAt() throws NoSuchFieldException, IllegalAccessException {
        SampleEntity entity = new SampleEntity("Hello");
        sampleJpaRepository.save(entity);

        assertNotNull(entity.getId());
        assertEquals("Hello", entity.getName());
        assertNotNull(getCreatedAt(entity));
    }

    private LocalDateTime getCreatedAt(SampleEntity entity) throws NoSuchFieldException, IllegalAccessException {
        Field createdAtField = SampleEntity.class.getSuperclass().getDeclaredField("createdAt");
        createdAtField.setAccessible(true);

        return (LocalDateTime) createdAtField.get(entity);
    }
}
