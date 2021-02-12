package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.parsing.EllipseParser;
import com.epam.task.third.parsing.EllipseValidator;
import com.epam.task.third.parsing.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class EllipseCreatorTest {

    private EllipseCreator creator;

    @Test
    public void testCreateShouldReturnListOfAllArrays() throws ValidationException, DataException {
        //given
        List<Ellipse> ellipses = Arrays.asList(
            new Ellipse(1.0, -2.0, 4.123, -12),
            new Ellipse(-15.1, 4.8, 5.678, 3.0),
            new Ellipse(1.0, 1.0, -1.0, -1.0)
        );
        initTest1(ellipses);

        //when
        List<Ellipse> result = creator.create();

        //then
        Assert.assertEquals(ellipses, result);
    }

    private void initTest1(List<Ellipse> ellipses) throws DataException, ValidationException {
        List<String> data = Arrays.asList(
                "1.0 -2.0 4.123 -12",
                "-15.1 4.8 5.678 3.0",
                "1.0 1.0 -1.0 -1.0"
        );

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.read()).thenReturn(data);

        EllipseValidator validator = Mockito.mock(EllipseValidator.class);
        doNothing().when(validator).check(anyString());

        EllipseParser parser = Mockito.mock(EllipseParser.class);
        when(parser.parse("1.0 -2.0 4.123 -12")) .thenReturn(ellipses.get(0));
        when(parser.parse("-15.1 4.8 5.678 3.0")).thenReturn(ellipses.get(1));
        when(parser.parse("1.0 1.0 -1.0 -1.0"))  .thenReturn(ellipses.get(2));

        creator = new EllipseCreator(dataReader, validator, parser);
    }

    @Test
    public void testCreateShouldReturnListOfArraysExcludingIncorrect() throws ValidationException, DataException {
        //given
        List<Ellipse> ellipses = Collections.singletonList(new Ellipse(1.14, -1.0, 6.778, 10.0));
        initTest2(ellipses);

        ///when
        List<Ellipse> result = creator.create();

        //then
        Assert.assertEquals(ellipses, result);
    }

    private void initTest2(List<Ellipse> ellipses) throws DataException, ValidationException {
        List<String> data = Arrays.asList(
                "-15.1 4z.8 -5.678 3.0",
                "1.14, -1.0, 6.778, 10.0",
                "1.0 1.0z-1.0z-1.0"
        );

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.read()).thenReturn(data);

        EllipseValidator validator = Mockito.mock(EllipseValidator.class);
        doThrow(ValidationException.class).when(validator).check("-15.1 4z.8 -5.678 3.0");
        doNothing().when(validator).check("1.14, -1.0, 6.778, 10.0");
        doThrow(ValidationException.class).when(validator).check("1.0 1.0z-1.0z-1.0");

        EllipseParser parser = Mockito.mock(EllipseParser.class);
        when(parser.parse("1.14, -1.0, 6.778, 10.0")).thenReturn(ellipses.get(0));

        creator = new EllipseCreator(dataReader, validator, parser);
    }

}
