package com.iwsaitw.base.persistence.base;

import com.iwsaitw.base.persistence.export.testcontainer.BasePersistenceTest;
import com.iwsaitw.base.persistence.base.config.BaseEntityTestConfig;
import com.iwsaitw.base.persistence.base.config.BaseTestEntity;
import com.iwsaitw.base.persistence.base.config.BaseTestJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = BaseEntityTestConfig.class)
public class BaseEntityTest extends BasePersistenceTest {

    @Autowired
    private BaseTestJpaRepository testJpaRepository;

    @BeforeEach()
    public void setup() {
        testJpaRepository.deleteAll();
    }

    @Test
    public void contextLoads() {}

    @Test
    public void should_have_no_argument_constructor() {
        Constructor<?>[] constructors = BaseEntity.class.getConstructors();

        Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                .filter((c) -> c.getParameters().length == 0)
                .findAny();

        assertTrue(constructor.isPresent());
    }

    @Test
    public void should_assign_id_with_constructor() {
        Constructor<?>[] constructors = BaseEntity.class.getConstructors();

        Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                .filter((c) -> c.getParameterCount() == 1)
                .filter((c) -> c.getParameterTypes()[0] == Long.class)
                .findAny();

        assertTrue(constructor.isPresent());
    }

    @Test
    public void should_not_be_able_to_access_id_when_it_is_null() {
        BaseTestEntity entity = new BaseTestEntity("name");
        assertThrows(IllegalStateException.class, entity::getId);
    }

    @Test
    public void should_generate_id_automatically_when_it_saves() {
        BaseTestEntity entity = new BaseTestEntity("name");
        testJpaRepository.save(entity);

        assertNotNull(entity.getId());
    }

    @Test
    public void should_generate_createdAt_when_it_saves() throws NoSuchFieldException, IllegalAccessException {
        BaseTestEntity entity = new BaseTestEntity("name");
        assertNull(getCreatedAt(entity));

        testJpaRepository.saveAndFlush(entity);
        assertNotNull(getCreatedAt(entity));
    }

    private LocalDateTime getCreatedAt(BaseEntity entity) throws NoSuchFieldException, IllegalAccessException {
        Field nameField = BaseTestEntity.class.getSuperclass().getDeclaredField("createdAt");
        nameField.setAccessible(true);

        return (LocalDateTime) nameField.get(entity);
    }
}