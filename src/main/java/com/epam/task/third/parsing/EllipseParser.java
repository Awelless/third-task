package com.epam.task.third.parsing;

import com.epam.task.third.entity.Ellipse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseParser {

    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public Ellipse parse(String line) {

        Matcher numberMatcher = NUMBER_PATTERN.matcher(line);

        List<Double> coordinates = new ArrayList<>();

        while(numberMatcher.find()) {
            double coordinate = Double.parseDouble(numberMatcher.group());
            coordinates.add(coordinate);
        }

        return new Ellipse(
                coordinates.get(0),
                coordinates.get(1),
                coordinates.get(2),
                coordinates.get(3)
        );
    }
}
