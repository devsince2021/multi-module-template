package com.iwsaitw.template.persistence.sample;

import com.iwsaitw.template.persistence.entity.SampleEntity;
import com.iwsaitw.base.persistence.base.BaseEntity;
import com.iwsaitw.base.persistence.base.EditableEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        public void should_inherit_editable_entity() {
            SampleEntity entity = new SampleEntity("name");
            assertInstanceOf(EditableEntity.class, entity);
        }

        @Test
        public void should_have_name_as_private_field() throws NoSuchFieldException {
            Field field = SampleEntity.class.getDeclaredField("name");
            assertTrue(Modifier.isPrivate(field.getModifiers()));
            assertEquals(String.class, field.getType());
        }
    }
}
