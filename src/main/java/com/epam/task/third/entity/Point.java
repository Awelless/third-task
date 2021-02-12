package com.epam.task.third.entity;

public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point o) {
        this.x = o.x;
        this.y = o.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        Point point = (Point) o;

        return Double.compare(point.x, x) == 0 &&
               Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * x + y);
    }

    @Override
    public String toString() {
        return String.format("x: %f,\n y: %f", x, y);
    }
}
