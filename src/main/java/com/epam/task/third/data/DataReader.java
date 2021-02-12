package com.epam.task.third.data;

import java.util.List;

public interface DataReader {
    List<String> read() throws DataException;
}
