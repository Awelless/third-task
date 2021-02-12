package com.epam.task.third.repository;

import com.epam.task.third.entity.Ellipse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

public class EllipseRepositoryTest {

    private EllipseRepository ellipseRepository;

    private static final Ellipse ELLIPSE_1 = new Ellipse(0.0, 0.0, 1.0, 1.0);
    private static final Ellipse ELLIPSE_2 = new Ellipse(2.0, 0.0, 1.0, 1.0);
    private static final Ellipse ELLIPSE_3 = new Ellipse(3.0, 0.0, 1.0, 1.0);

    @Before
    public void init() {
        ellipseRepository = new EllipseRepository();

        ellipseRepository.save(ELLIPSE_1);
        ellipseRepository.save(ELLIPSE_2);
        ellipseRepository.save(ELLIPSE_3);
    }

    @Test
    public void testGetAllShouldReturnAll() {
        List<Ellipse> result = ellipseRepository.getAll();

        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testSaveShouldAddWhenNewApplied() {
        //given
        Ellipse ellipse = new Ellipse(5.0, 0.0, 0.0, 0.0);

        //when
        ellipseRepository.save(ellipse);

        //then
        List<Ellipse> ellipses = ellipseRepository.getAll();

        Assert.assertEquals(4, ellipses.size());
    }

    @Test
    public void testSaveShouldUpdateWhenOldApplied() {
        //when
        ellipseRepository.save(ELLIPSE_2);

        //then
        List<Ellipse> ellipses = ellipseRepository.getAll();

        Assert.assertEquals(3, ellipses.size());
    }

    @Test
    public void testSaveShouldRemove() {
        //when
        ellipseRepository.remove(ELLIPSE_2);

        //then
        List<Ellipse> ellipses = ellipseRepository.getAll();

        Assert.assertEquals(2, ellipses.size());
    }

    @Test
    public void testGetBySpecification() {
        EllipseSpecification ellipseSpecification = Mockito.mock(EllipseSpecification.class);
        when(ellipseSpecification.specified(ELLIPSE_1)).thenReturn(true);
        when(ellipseSpecification.specified(ELLIPSE_2)).thenReturn(false);
        when(ellipseSpecification.specified(ELLIPSE_3)).thenReturn(true);

        List<Ellipse> result = ellipseRepository.getBySpecification(ellipseSpecification);

        Assert.assertEquals(2, result.size());
    }
}
