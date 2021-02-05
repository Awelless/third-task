package com.epam.task.third.repository;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.Point;

public class EllipseSpecificationByPoint implements EllipseSpecification {

    private final Point point;

    public EllipseSpecificationByPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean specified(Ellipse o) {
        return point.equals(o.getFirstPoint()) ||
               point.equals(o.getSecondPoint());
    }

}
