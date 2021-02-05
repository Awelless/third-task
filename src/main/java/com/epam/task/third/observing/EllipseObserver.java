package com.epam.task.third.observing;

import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.entity.EllipseParameters;
import com.epam.task.third.logic.EllipseLogic;

import java.util.HashMap;
import java.util.Map;

public class EllipseObserver implements Observer {

    private static EllipseObserver INSTANCE;

    private final EllipseLogic ellipseLogic;
    private final Map<Ellipse, EllipseParameters> parameters = new HashMap<>();

    private EllipseObserver(EllipseLogic ellipseLogic) {
        this.ellipseLogic = ellipseLogic;
    }

    public static EllipseObserver getInstance(EllipseLogic ellipseLogic) {
        if (INSTANCE == null) {
            INSTANCE = new EllipseObserver(ellipseLogic);
        }

        return INSTANCE;
    }

    @Override
    public void update(Object o) throws ObserverException {
        if (!(o instanceof Ellipse)) {
            throw new ObserverException("Argument should be instance of Ellipse");
        }

        Ellipse ellipse = (Ellipse) o;

        double newArea      = ellipseLogic.findArea(ellipse);
        double newPerimeter = ellipseLogic.findPerimeter(ellipse);

        EllipseParameters ellipseParameters = new EllipseParameters(newArea, newPerimeter);

        parameters.put(ellipse, ellipseParameters);
    }

    public Map<Ellipse, EllipseParameters> getParameters() {
        return parameters;
    }
}
