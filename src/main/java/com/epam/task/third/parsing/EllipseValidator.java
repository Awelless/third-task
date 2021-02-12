package com.epam.task.third.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseValidator {

    private static final String INVALID_REGEX = "[^\\d. \\-]";
    private static final Pattern INVALID_PATTERN = Pattern.compile(INVALID_REGEX);

    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    private static final String SPACE_REGEX = " +";

    public void check(String line) throws ValidationException {

        Matcher invalidMatcher = INVALID_PATTERN.matcher(line);

        if (invalidMatcher.find()) {
            throw new ValidationException("Applied line is invalid");
        }

        Matcher numberMatcher = NUMBER_PATTERN.matcher(line);

        int previousMatchEnd = -1;
        int groupCount = 0;

        while (numberMatcher.find()) {

            ++groupCount;

            int start = numberMatcher.start();

            if (previousMatchEnd != -1) {
                String separator = line.substring(previousMatchEnd, start);

                if (!separator.matches(SPACE_REGEX)) {
                    throw new ValidationException("Applied line is invalid");
                }
            }

            previousMatchEnd = numberMatcher.end();
        }

        if (groupCount != 4) {
            throw new ValidationException("Applied line is invalid");
        }
    }
}
