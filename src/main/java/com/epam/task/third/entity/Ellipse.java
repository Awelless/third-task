package com.epam.task.third.entity;

import java.util.HashSet;
import java.util.Set;

public class Ellipse {

    private final Point firstCorner;
    private final Point secondCorner;

    public Ellipse(Point firstCorner, Point secondCorner) {
        this.firstCorner = firstCorner;
        this.secondCorner = secondCorner;
    }

    public Ellipse(double x1, double y1, double x2, double y2) {
        this.firstCorner  = new Point(x1, y1);
        this.secondCorner = new Point(x2, y2);
    }

    public Point getFirstCorner() {
        return firstCorner;
    }

    public Point getSecondCorner() {
        return secondCorner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof Ellipse)) {
            return false;
        }

        Ellipse ellipse = (Ellipse) o;

        Set<Double> thisXCoordinates = new HashSet<Double>() {{
            add(firstCorner.getX());
            add(secondCorner.getX());
        }};

        Set<Double> thisYCoordinates = new HashSet<Double>() {{
            add(firstCorner.getY());
            add(secondCorner.getY());
        }};

        Set<Double> ellipseXCoordinates = new HashSet<Double>() {{
            add(ellipse.firstCorner.getX());
            add(ellipse.secondCorner.getX());
        }};

        Set<Double> ellipseYCoordinates = new HashSet<Double>() {{
            add(ellipse.firstCorner.getY());
            add(ellipse.secondCorner.getY());
        }};



        return thisXCoordinates.equals(ellipseXCoordinates) &&
               thisYCoordinates.equals(ellipseYCoordinates);
    }

    @Override
    public int hashCode() {
        return 951649 * firstCorner.hashCode() + secondCorner.hashCode();
    }

    @Override
    public String toString() {
        return String.format("firstCorner: %s\n, secondCorner: %s", firstCorner, secondCorner);
    }
}
