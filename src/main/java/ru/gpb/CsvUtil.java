package ru.gpb;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CsvUtil {
    /**
    Читает csv файл в classpath с разделителем.
     Список с массиво строк
     */
    public static void main(String[] args) {

    }
    public  static List<String[]> getAllLines(String testCsvResourcePath, char separator) {
        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .withQuoteChar('"')
                    .build();

            Reader reader = getReader(testCsvResourcePath);

            return
                    Collections.unmodifiableList(new CSVReaderBuilder(reader)
                            .withCSVParser(parser)
                            .withSkipLines(0)
                            .build()
                            .readAll());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удаётся считать csv файл");
        }
    }

        public  static Reader getReader(String classPathResourcePath) throws FileNotFoundException {
           FileInputStream InputStream  = new FileInputStream(classPathResourcePath);
           return new InputStreamReader(Objects.requireNonNull(InputStream), StandardCharsets.UTF_8);
    }
}

