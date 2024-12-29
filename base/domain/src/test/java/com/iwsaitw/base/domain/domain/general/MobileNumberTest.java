package com.iwsaitw.base.domain.domain.general;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MobileNumberTest {
    @Test
    public void should_keep_constructor_private() {
        Constructor<?>[] constructors = MobileNumber.class.getConstructors();
        boolean hasNonPrivateConstructor = Arrays.stream(constructors)
                .anyMatch((c) -> !Modifier.isPrivate(c.getModifiers()));

        assertFalse(hasNonPrivateConstructor);
    }

    @Test
    public void should_have_value_field_as_private_String_type() throws NoSuchFieldException {
        Field field = MobileNumber.class.getDeclaredField("value");
        assertTrue(Modifier.isPrivate(field.getModifiers()));
        assertEquals(String.class, field.getType());
    }

    @Test
    public void should_instantiate_if_mobile_number_is_valid() {
        String validNumber = "010-1111-1111";
        MobileNumber mobileNumber = MobileNumber.create(validNumber);
        assertInstanceOf(MobileNumber.class, mobileNumber);
    }

    @Test
    public void should_throw_exception_if_mobile_number_has_invalid_format() {
        String invalid = "123";
        assertThrows(IllegalArgumentException.class,
                () -> MobileNumber.create(invalid)
        );
    }

    @Test
    public void should_throw_exception_if_mobile_number_does_not_includes_dashes() {
        String validNumber = "010-1111-1111";
        MobileNumber mobileNumber = MobileNumber.create(validNumber);
        assertInstanceOf(MobileNumber.class, mobileNumber);
    }

    @Test
    public void should_be_equals_when_two_objects_have_same_mobile_number() {
        MobileNumber mb1 = MobileNumber.create("010-1111-1111");
        MobileNumber mb2 = MobileNumber.create("010-1111-1111");

        assertEquals(mb1, mb2);
    }
}
