package com.epam.task.third.observing;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObservableEllipse extends Ellipse implements Observable {

    private static final Logger LOGGER = LogManager.getLogger(Observer.class);

    private final List<Observer> observers = new ArrayList<>();

    public ObservableEllipse(Point firstCorner, Point secondCorner) {
        super(firstCorner, secondCorner);
    }

    public ObservableEllipse(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public ObservableEllipse(Ellipse ellipse) {
        super(ellipse);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            try {
                observer.update(this);
            } catch (ObserverException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ObservableEllipse)) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        ObservableEllipse observableEllipse = (ObservableEllipse) o;

        return observers.equals(observableEllipse.observers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), observers);
    }
}
