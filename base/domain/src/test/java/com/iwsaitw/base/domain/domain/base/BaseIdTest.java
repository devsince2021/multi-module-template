package com.iwsaitw.base.domain.domain.base;

import com.iwsaitw.base.domain.domain.base.BaseId;
import com.iwsaitw.base.domain.exception.BaseException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BaseIdTest {
    @Test
    public void contextLoads(){}

    @Test
    public void should_have_name_field_as_private_Long() throws NoSuchFieldException {
        Field field = BaseId.class.getDeclaredField("value");
        assertTrue(Modifier.isPrivate(field.getModifiers()));
        assertEquals(Long.class, field.getType());
    }

    @Test
    public void should_have_constructor_with_one_parameter_as_Long_type() {
        Constructor<?>[] constructors = BaseId.class.getDeclaredConstructors();

        Optional<Constructor<?>> constructor = Arrays.stream(constructors)
                .filter((c) -> c.getParameters().length == 1)
                .filter((c) -> c.getParameterTypes()[0] == Long.class)
                .findAny();

        assertTrue(constructor.isPresent());
    }

    @Test
    public void should_two_objects_equals_if_values_are_the_same() {
        BaseId id1 = new BaseId(1L);
        BaseId id2 = new BaseId(1L);

        assertEquals(id1, id2);
    }

    @Test
    public void should_not_be_able_to_have_0_as_id() {
        assertThrows(BaseException.class, () -> new BaseId(0L));
    }

    @Test
    public void should_not_be_able_to_have_negative_number_as_id() {
        assertThrows(BaseException.class, () -> new BaseId(-1L));
    }

    @Test
    public void should_be_able_to_have_null_as_id() {
        BaseId id = new BaseId(null);
        assertNull(id.getId());
    }
}
