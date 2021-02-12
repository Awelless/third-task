package com.epam.task.third.comparator;

import com.epam.task.third.entity.Ellipse;

public class EllipseComparatorByPoint implements EllipseComparator {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        double minFirstX = Math.min(o1.getFirstPoint().getX(),
                                    o1.getSecondPoint().getX());

        double minSecondX = Math.min(o2.getFirstPoint().getX(),
                                     o2.getSecondPoint().getX());

        if (minFirstX != minSecondX) {
            return (int) Math.ceil(minFirstX - minSecondX);
        }

        double minFirstY = Math.min(o1.getFirstPoint().getY(),
                                    o1.getSecondPoint().getY());

        double minSecondY = Math.min(o2.getFirstPoint().getY(),
                                     o2.getSecondPoint().getY());

        return (int) Math.ceil(minFirstY - minSecondY);
    }
}
