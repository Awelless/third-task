package com.epam.task.third.repository;

import java.util.List;

public interface Repository<T, S> {

    void save(T o);
    void remove(T o);

    List<T> getBySpecification(S specification);

    List<T> getAll();

}
