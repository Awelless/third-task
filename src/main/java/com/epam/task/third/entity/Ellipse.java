package com.epam.task.third.entity;

import java.util.HashSet;
import java.util.Set;

public class Ellipse {

    private final Point firstPoint;
    private final Point secondPoint;

    public Ellipse(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Ellipse(double x1, double y1, double x2, double y2) {
        this.firstPoint = new Point(x1, y1);
        this.secondPoint = new Point(x2, y2);
    }

    public Ellipse(Ellipse o) {
        this.firstPoint = new Point(o.firstPoint);
        this.secondPoint = new Point(o.secondPoint);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Ellipse)) {
            return false;
        }

        Ellipse ellipse = (Ellipse) o;

        Set<Double> thisXCoordinates = new HashSet<Double>() {{
            add(firstPoint.getX());
            add(secondPoint.getX());
        }};

        Set<Double> thisYCoordinates = new HashSet<Double>() {{
            add(firstPoint.getY());
            add(secondPoint.getY());
        }};

        Set<Double> ellipseXCoordinates = new HashSet<Double>() {{
            add(ellipse.firstPoint.getX());
            add(ellipse.secondPoint.getX());
        }};

        Set<Double> ellipseYCoordinates = new HashSet<Double>() {{
            add(ellipse.firstPoint.getY());
            add(ellipse.secondPoint.getY());
        }};



        return thisXCoordinates.equals(ellipseXCoordinates) &&
               thisYCoordinates.equals(ellipseYCoordinates);
    }

    @Override
    public int hashCode() {
        return 31 * firstPoint.hashCode() + secondPoint.hashCode();
    }

    @Override
    public String toString() {
        return String.format("firstCorner: %s\n, secondCorner: %s", firstPoint, secondPoint);
    }
}
