package com.epam.task.third.logic;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.Point;

public class EllipseLogic {

    public boolean isValid(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        return firstCorner.getX() != secondCorner.getX() &&
               firstCorner.getY() != secondCorner.getY();
    }

    public double findSquare(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        double xSemiaxis = Math.abs(firstCorner.getX() - secondCorner.getX()) / 2;
        double ySemiaxis = Math.abs(firstCorner.getY() - secondCorner.getY()) / 2;

        return Math.PI * xSemiaxis * ySemiaxis;
    }

    public double findPerimeter(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        double xSemiaxis = Math.abs(firstCorner.getX() - secondCorner.getX()) / 2;
        double ySemiaxis = Math.abs(firstCorner.getY() - secondCorner.getY()) / 2;

        return 4.0 * (Math.PI * xSemiaxis * ySemiaxis + Math.abs(xSemiaxis - ySemiaxis))
                / (xSemiaxis + ySemiaxis);
    }

    boolean isCrossingXOrdinate(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        //if one x coordinate is positive and one is negative, multiplication will be negative
        return firstCorner.getX() * secondCorner.getX() <= 0;
    }

    boolean isCrossingYOrdinate(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        //if one y coordinate is positive and one is negative, multiplication will be negative
        return firstCorner.getY() * secondCorner.getY() <= 0;
    }

    boolean isCircle(Ellipse ellipse) {
        Point firstCorner  = ellipse.getFirstCorner();
        Point secondCorner = ellipse.getSecondCorner();

        double xAxis = Math.abs(firstCorner.getX() - secondCorner.getX());
        double yAxis = Math.abs(firstCorner.getY() - secondCorner.getY());

        return Double.compare(xAxis, yAxis) == 0;
    }
}
