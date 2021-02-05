package com.epam.task.third.comparator;

import com.epam.task.third.entity.Ellipse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EllipseComparatorByPointTest {

    private final EllipseComparator ellipseComparatorByPoint = new EllipseComparatorByPoint();

    private List<Ellipse> ellipses;

    private static final Ellipse ELLIPSE_1 = new Ellipse(0.0, 0.0, 1.0, 1.0);
    private static final Ellipse ELLIPSE_2 = new Ellipse(2.0, 0.0, 1.0, 1.0);
    private static final Ellipse ELLIPSE_3 = new Ellipse(2.0, 1.0, 1.0, 1.0);

    @Before
    public void init() {
        ellipses = new ArrayList<>();

        ellipses.add(ELLIPSE_2);
        ellipses.add(ELLIPSE_1);
        ellipses.add(ELLIPSE_3);
    }

    @Test
    public void test() {
        //when
        ellipses.sort(ellipseComparatorByPoint);

        //then
        Assert.assertEquals(ELLIPSE_1, ellipses.get(0));
        Assert.assertEquals(ELLIPSE_2, ellipses.get(1));
        Assert.assertEquals(ELLIPSE_3, ellipses.get(2));
    }
}
