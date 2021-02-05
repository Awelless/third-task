package com.epam.task.third.entity;

public class EllipseParameters {

    private double area      = 0.0;
    private double perimeter = 0.0;

    public EllipseParameters(double area, double perimeter) {
        this.area      = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof EllipseParameters)) {
            return false;
        }

        EllipseParameters ellipseParameters = (EllipseParameters) o;

        return Double.compare(area,      ellipseParameters.getArea())      == 0 &&
               Double.compare(perimeter, ellipseParameters.getPerimeter()) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * area + perimeter);
    }
}
