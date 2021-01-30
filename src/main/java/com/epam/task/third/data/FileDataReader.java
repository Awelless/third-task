package com.epam.task.third.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {

    private final String filename;

    public FileDataReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() throws DataException {

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            List<String> data = new ArrayList<>();

            while (bufferedReader.ready()) {
                String currentLine = bufferedReader.readLine();
                data.add(currentLine);
            }

            return data;

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);

        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // ignore ... any IO errors are already reported
                }
            }

            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // ignore ... any IO errors are already reported
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    // ignore ... any IO errors are already reported
                }
            }
        }

    }
}
