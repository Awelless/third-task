package com.epam.task.third.observing;

public interface Observable {

    void attachObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
