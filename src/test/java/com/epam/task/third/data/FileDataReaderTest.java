package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private DataReader dataReader;

    public static final String correctInputFilename = "./src/test/resources/correct_input.txt";
    public static final String incorrectInputFilename = "./src/test/resources/incorrect_input.txt";
    public static final String incorrectFilename = "./src/test/resources/input_123.txt";

    @Test
    public void testShouldReadWhenCorrectInputApplied() throws DataException {
        dataReader = new FileDataReader(correctInputFilename);
        List<String> expected = Arrays.asList("1.0 2.567 -3.7 2.90", "7.8 -10.123 -10.345 -12");

        List<String> result = dataReader.read();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testShouldReadWhenIncorrectInputApplied() throws DataException {
        dataReader = new FileDataReader(incorrectInputFilename);
        List<String> expected = Arrays.asList("1.0 2.0 3.0 4.0z", "123 342 pqqw fdm");

        List<String> result = dataReader.read();

        Assert.assertEquals(expected, result);
    }

    @Test(expected = DataException.class)
    public void testShouldThrowExceptionWhenIncorrectFilenameApplied() throws DataException {
        dataReader = new FileDataReader(incorrectFilename);

        List<String> result = dataReader.read();
    }
}
