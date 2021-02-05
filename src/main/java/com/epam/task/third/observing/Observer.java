package com.epam.task.third.observing;

public interface Observer {

    void update(Object o) throws ObserverException;

}
