package com.epam.task.third.logic;

import com.epam.task.third.entity.Ellipse;
import org.junit.Assert;
import org.junit.Test;

public class EllipseLogicTest {

    private final EllipseLogic logic = new EllipseLogic();

    private static final Ellipse Ellipse = new Ellipse(0.0, 0.0, 3.0, 4.0);
    private static final double Ellipse_SQUARE = 9.4247;
    private static final double Ellipse_PERIMETER = 11.3426;

    private static final double DELTA = 0.001;

    @Test
    public void testIsValidShouldReturnTrueWhenCorrectApplied() {
        boolean result = logic.isValid(Ellipse);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenIncorrectApplied() {
        Ellipse ellipse = new Ellipse(1.0, 2.0, 1.0, 4.0);

        boolean result = logic.isValid(ellipse);

        Assert.assertFalse(result);
    }

    @Test
    public void testFindSquare() {
        double result = logic.findArea(Ellipse);

        Assert.assertEquals(Ellipse_SQUARE, result, DELTA);
    }

    @Test
    public void testFindPerimeter() {
        double result = logic.findPerimeter(Ellipse);

        Assert.assertEquals(Ellipse_PERIMETER, result, DELTA);
    }

    @Test
    public void testIsCrossingXOrdinateShouldReturnTrueWhenCrossing() {
        Ellipse ellipse = new Ellipse(-1, 1, 1, -1);

        boolean result = logic.isCrossingXOrdinate(ellipse);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsCrossingXOrdinateShouldReturnFalseWhenNotCrossing() {
        Ellipse ellipse = new Ellipse(2, 1, 1, -1);

        boolean result = logic.isCrossingXOrdinate(ellipse);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsCrossingYOrdinateShouldReturnTrueWhenCrossing() {
        Ellipse ellipse = new Ellipse(-1, 1, 1, -1);

        boolean result = logic.isCrossingYOrdinate(ellipse);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsCrossingYOrdinateShouldReturnFalseWhenNotCrossing() {
        Ellipse ellipse = new Ellipse(2, 1, 1, 2);

        boolean result = logic.isCrossingYOrdinate(ellipse);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsCircleShouldReturnTrueWhenIsCircle() {
        Ellipse ellipse = new Ellipse(-1, 1, 1, -1);

        boolean result = logic.isCircle(ellipse);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsCircleShouldReturnFalseWhenNotCircle() {
        Ellipse ellipse = new Ellipse(-1, 2, 1, -1);

        boolean result = logic.isCircle(ellipse);

        Assert.assertFalse(result);
    }
}
