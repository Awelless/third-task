package com.epam.task.third.repository;

import com.epam.task.third.entity.Ellipse;

import java.util.ArrayList;
import java.util.List;

public class EllipseRepository implements Repository<Ellipse, EllipseSpecification> {

    List<Ellipse> ellipses = new ArrayList<>();

    @Override
    public void save(Ellipse o) {
        ellipses.remove(o);
        ellipses.add(o);
    }

    @Override
    public void remove(Ellipse o) {
        ellipses.remove(o);
    }

    @Override
    public List<Ellipse> getBySpecification(EllipseSpecification specification) {
        List<Ellipse> specifiedEllipses = new ArrayList<>();

        for (Ellipse ellipse : ellipses) {
            if (specification.specified(ellipse)) {
                specifiedEllipses.add(ellipse);
            }
        }

        return specifiedEllipses;
    }

    @Override
    public List<Ellipse> getAll() {
        return ellipses;
    }
}
