package com.epam.task.third.observing;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.EllipseParameters;
import com.epam.task.third.logic.EllipseLogic;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class EllipseObserverTest {

    private static EllipseObserver OBSERVER;

    private static final double DELTA = 0.01;

    private static final double AREA      = 0.785;
    private static final double PERIMETER = 3.141;

    @BeforeClass
    public static void init() {
        EllipseLogic ellipseLogic = Mockito.mock(EllipseLogic.class);

        when(ellipseLogic.findArea(any()))     .thenReturn(AREA);
        when(ellipseLogic.findPerimeter(any())).thenReturn(PERIMETER);

        OBSERVER = EllipseObserver.getInstance(ellipseLogic);
    }

    @Test
    public void testUpdateShouldUpdateParametersWhenCorrectApplied() throws ObserverException {
        //given
        Ellipse ellipse = new Ellipse(0.0, 0.0, 1.0, 1.0);

        //when
        OBSERVER.update(ellipse);

        //then
        //checking if update method works correctly
        Map<Ellipse, EllipseParameters> parameters = OBSERVER.getParameters();
        EllipseParameters ellipseParameters = parameters.get(ellipse);

        Assert.assertEquals(AREA,      ellipseParameters.getArea(),      DELTA);
        Assert.assertEquals(PERIMETER, ellipseParameters.getPerimeter(), DELTA);
    }

    @Test(expected = ObserverException.class)
    public void testUpdateShouldThrowExceptionWhenNotEllipseApplied() throws ObserverException {
        String string = "123";

        OBSERVER.update(string);
    }
}
