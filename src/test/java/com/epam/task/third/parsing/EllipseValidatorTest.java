package com.epam.task.third.parsing;

import org.junit.Test;

public class EllipseValidatorTest {

    private final EllipseValidator validator = new EllipseValidator();

    @Test
    public void testShouldValidateWhenCorrectApplied() throws ValidationException {
        String data = "1.0 2.0 -1.23   -10";

        validator.check(data);
    }

    @Test(expected = ValidationException.class)
    public void testShouldThrowExceptionWhenIncorrectApplied() throws ValidationException {
        String data = "1.0 2.0 -1.23 -10 11235";

        validator.check(data);
    }

    @Test(expected = ValidationException.class)
    public void testShouldThrowExceptionWhenIncorrectWithLettersApplied() throws ValidationException {
        String data = "1.0a 2.0 -1.23z -10";

        validator.check(data);
    }

    @Test(expected = ValidationException.class)
    public void testShouldThrowExceptionWhenIncorrectSeparatorApplied() throws ValidationException {
        String data = "1.0 2.0 .   -1.23 -10";

        validator.check(data);
    }

    @Test(expected = ValidationException.class)
    public void testShouldThrowExceptionWhenIncorrectSignsApplied() throws ValidationException {
        String data = "1.0 2.0-0 -1.23 -10";

        validator.check(data);
    }

    @Test(expected = ValidationException.class)
    public void testShouldThrowExceptionWhenIncorrectDotsApplied() throws ValidationException {
        String data = "1.0 2.0 -1.2.3 -10";

        validator.check(data);
    }
}
