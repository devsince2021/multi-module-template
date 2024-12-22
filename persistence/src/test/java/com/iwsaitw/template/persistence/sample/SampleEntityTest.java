package com.iwsaitw.template.persistence.sample;

import com.iwsaitw.template.persistence.base.BaseEntity;
import com.iwsaitw.template.persistence.entity.SampleEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SampleEntityTest {
    @Nested
    class StructureTest {

        @Test
        public void should_have_no_argument_constructor() {
            Constructor<?>[] constructors = SampleEntity.class.getConstructors();

            Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                    .filter((c) -> c.getParameters().length == 0)
                    .findAny();

            assertTrue(constructor.isPresent());
        }

        @Test
        public void should_inherit_base_entity() {
            SampleEntity entity = new SampleEntity("name");
            assertInstanceOf(BaseEntity.class, entity);
        }

        @Test
        public void should_have_name_as_private_field() throws NoSuchFieldException {
            Field field = SampleEntity.class.getDeclaredField("name");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(String.class, field.getType());
        }

        @Test
        public void should_have_licenseNumber_as_private_field() throws NoSuchFieldException {
            Field field = SampleEntity.class.getDeclaredField("licenseNumber");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(String.class, field.getType());
        }
    }

    @Nested
    class CreateTest {
        private final Long id = 1L;
        private final String name = "test";
        private final String licenseNumber = "111-11-11111";

        @Test
        public void should_be_able_to_instantiate_without_parameters() {
            SampleEntity organizationEntity = new SampleEntity();
            assertInstanceOf(SampleEntity.class, organizationEntity);
        }

        @Test
        public void should_be_able_to_instantiate_with_name_and_license_number() {
            SampleEntity organizationEntity = new SampleEntity(name);
            assertInstanceOf(SampleEntity.class, organizationEntity);
        }

        @Test
        public void should_be_able_to_instantiate_with_id_name_license() {
            SampleEntity organizationEntity = new SampleEntity(id, name);
            assertInstanceOf(SampleEntity.class, organizationEntity);
        }

        @Test
        public void should_throw_exception_if_name_is_null() {
            assertThrows(IllegalArgumentException.class, () -> {
                new SampleEntity(id, null);
            });

            assertThrows(IllegalArgumentException.class, () -> {
                new SampleEntity(null, licenseNumber);
            });
        }

        @Test
        public void should_not_be_able_to_access_id_if_id_is_null() {
            SampleEntity entity = new SampleEntity(name);
            assertThrows(IllegalStateException.class, entity::getId);
        }
    }


}
