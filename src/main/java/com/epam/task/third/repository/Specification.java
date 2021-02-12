package com.epam.task.third.repository;

public interface Specification<T> {
    boolean specified(T o);
}
