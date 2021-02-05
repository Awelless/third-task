package com.epam.task.third.observing;

import com.epam.task.third.entity.Ellipse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

public class ObservableEllipseTest {

    private ObservableEllipse observableEllipse;

    private EllipseObserver ellipseObserver;

    private static final Ellipse ELLIPSE = new Ellipse(0.0, 0.0, 1.0, 1.0);

    @Before
    public void init() throws ObserverException {
        observableEllipse = new ObservableEllipse(ELLIPSE);

        ellipseObserver = Mockito.mock(EllipseObserver.class);

        doNothing().when(ellipseObserver).update(any());
    }

    @Test
    public void testAttachObserverShouldAttach() {
        //when
        observableEllipse.attachObserver(ellipseObserver);

        //then
        List<Observer> observers = observableEllipse.getObservers();
        Observer observer = observers.get(0);

        Assert.assertEquals(ellipseObserver, observer);
    }

    @Test
    public void testRemoveObserverShouldAttach() {
        //given
        observableEllipse.attachObserver(ellipseObserver);

        //when
        observableEllipse.removeObserver(ellipseObserver);

        //then
        List<Observer> observers = observableEllipse.getObservers();

        Assert.assertEquals(0, observers.size());
    }

    @Test
    public void testNotifyObserversShouldAttach() throws ObserverException {
        //given
        observableEllipse.attachObserver(ellipseObserver);

        //when
        observableEllipse.notifyObservers();

        Mockito.verify(ellipseObserver, Mockito.times(1)).update(any());
    }
}
