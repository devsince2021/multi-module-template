package com.iwsaitw.base.persistence.base;

import com.iwsaitw.base.persistence.export.testcontainer.BasePersistenceTest;
import com.iwsaitw.base.persistence.base.config.BaseEntityTestConfig;
import com.iwsaitw.base.persistence.base.config.EditableTestEntity;
import com.iwsaitw.base.persistence.base.config.EditableTestJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = BaseEntityTestConfig.class)
public class EditableEntityTest extends BasePersistenceTest {

    @Autowired
    private EditableTestJpaRepository testJpaRepository;

    @BeforeEach()
    public void setup() {
        testJpaRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void should_have_no_argument_constructor() {
        Constructor<?>[] constructors = EditableEntity.class.getConstructors();

        Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                .filter((c) -> c.getParameters().length == 0)
                .findAny();

        assertTrue(constructor.isPresent());
    }

    @Test
    public void should_assign_id_with_constructor() {
        Constructor<?>[] constructors = EditableEntity.class.getConstructors();

        Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                .filter((c) -> c.getParameterCount() == 1)
                .filter((c) -> c.getParameterTypes()[0] == Long.class)
                .findAny();

        assertTrue(constructor.isPresent());
    }

    @Test
    public void should_generate_updatedAt_when_it_create_at_first() throws NoSuchFieldException, IllegalAccessException {
        EditableTestEntity entity = new EditableTestEntity("new");
        testJpaRepository.saveAndFlush(entity);

        LocalDateTime createdAt = getCreatedAt(entity);
        LocalDateTime updatedAt = getUpdatedAt(entity);

        assertEquals(createdAt, updatedAt);
    }

    @Test
    public void should_generate_updatedAt_when_it_saves() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        EditableTestEntity entity = new EditableTestEntity("new");
        testJpaRepository.save(entity);

        LocalDateTime beforeUpdatedAt = getUpdatedAt(entity);

        entity.updateName("old");
        testJpaRepository.saveAndFlush(entity);

        LocalDateTime afterUpdatedAt = getUpdatedAt(entity);

        assertThat(afterUpdatedAt).isAfter(beforeUpdatedAt);
    }

    @Test
    public void should_not_generate_deletedAt_before_delete_method_invoked() throws NoSuchFieldException, IllegalAccessException {
        EditableTestEntity entity = new EditableTestEntity("new");
        testJpaRepository.save(entity);

        LocalDateTime deletedAt = getDeletedAt(entity);
        assertNull(deletedAt);

        entity.delete();
        testJpaRepository.saveAndFlush(entity);

        LocalDateTime afterDeletedAt = getDeletedAt(entity);
        assertNotNull(afterDeletedAt);
    }

    @Test
    public void should_be_true_after_deleted_method_invoked() {
        EditableTestEntity entity = new EditableTestEntity("new");
        assertFalse(entity.isDeleted());

        entity.delete();
        assertTrue(entity.isDeleted());
    }

    private LocalDateTime getCreatedAt(EditableTestEntity entity) throws NoSuchFieldException, IllegalAccessException {
        Field nameField = EditableTestEntity.class
                .getSuperclass()
                .getSuperclass()
                .getDeclaredField("createdAt");

        nameField.setAccessible(true);

        return (LocalDateTime) nameField.get(entity);
    }

    private LocalDateTime getUpdatedAt(EditableTestEntity entity) throws NoSuchFieldException, IllegalAccessException {
        Field nameField = EditableTestEntity.class.getSuperclass().getDeclaredField("updatedAt");
        nameField.setAccessible(true);

        return (LocalDateTime) nameField.get(entity);
    }

    private LocalDateTime getDeletedAt(EditableTestEntity entity) throws NoSuchFieldException, IllegalAccessException {
        Field nameField = EditableTestEntity.class.getSuperclass().getDeclaredField("deletedAt");
        nameField.setAccessible(true);

        return (LocalDateTime) nameField.get(entity);
    }
}