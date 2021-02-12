package com.epam.task.third.repository;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EllipseSpecificationByPointTest {

    private EllipseSpecification ellipseSpecificationByPoint;

    private static final Point POINT = new Point(0.0, 0.0);

    private static final Ellipse ELLIPSE_1 = new Ellipse(0.0, 0.0, 2.0, 3.0);
    private static final Ellipse ELLIPSE_2 = new Ellipse(1.0, 0.0, 3.0, 3.0);

    @Before
    public void init() {
        ellipseSpecificationByPoint = new EllipseSpecificationByPoint(POINT);
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenSuits() {
        boolean result = ellipseSpecificationByPoint.specified(ELLIPSE_1);

        Assert.assertTrue(result);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenNotSuits() {
        boolean result = ellipseSpecificationByPoint.specified(ELLIPSE_2);

        Assert.assertFalse(result);
    }
}
