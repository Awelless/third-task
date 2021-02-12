package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Ellipse;
import com.epam.task.third.parsing.EllipseParser;
import com.epam.task.third.parsing.EllipseValidator;
import com.epam.task.third.parsing.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EllipseCreator {

    private static final Logger LOGGER = LogManager.getLogger(EllipseCreator.class);

    private final DataReader dataReader;
    private final EllipseValidator validator;
    private final EllipseParser parser;

    public EllipseCreator(DataReader dataReader, EllipseValidator validator, EllipseParser parser) {
        this.dataReader = dataReader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Ellipse> create() throws DataException {

        List<String> data;

        try {
            LOGGER.info("Reading data");
            data = dataReader.read();

        } catch (DataException e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }

        List<Ellipse> ellipses = new ArrayList<>();

        for (int i = 0; i < data.size(); ++i) {

            String line = data.get(i);

            try {
                LOGGER.info("Validating line: {} ...", i + 1);
                validator.check(line);

                LOGGER.info("Correct. Parsing ...");
                Ellipse ellipse = parser.parse(line);
                ellipses.add(ellipse);

                LOGGER.info("Parsed");

            } catch (ValidationException e) {
                LOGGER.error("Invalid input in line: {}. Skipping", i + 1);
            }
        }

        return ellipses;
    }
}
