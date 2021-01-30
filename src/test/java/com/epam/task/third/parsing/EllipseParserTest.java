package com.epam.task.third.parsing;

import com.epam.task.third.entity.Ellipse;
import org.junit.Assert;
import org.junit.Test;

public class EllipseParserTest {

    private final EllipseParser parser = new EllipseParser();

    @Test
    public void testParseShouldReturnEllipseWhenPositivesApplied() {
        String data = "1.0 2 4.56764 8.001";
        Ellipse expected = new Ellipse(1.0, 2.0, 4.56764, 8.001);

        Ellipse result = parser.parse(data);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testParseShouldReturnEllipseWhenNegativesApplied() {
        String data = "-1.0 -2 -4.56764 -8.001";
        Ellipse expected = new Ellipse(-1.0, -2.0, -4.56764, -8.001);

        Ellipse result = parser.parse(data);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testParseShouldReturnEllipseWhenMixedApplied() {
        String data = "1.0 2 -4.56764 8.001";
        Ellipse expected = new Ellipse(1.0, 2.0, -4.56764, 8.001);

        Ellipse result = parser.parse(data);

        Assert.assertEquals(expected, result);
    }
}
