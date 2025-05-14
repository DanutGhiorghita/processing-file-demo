package com.processing.file.csv.parser;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public final class CSVParser {

    public static <T> List<T> read(Class<T> valueType, final String filePath) throws FileNotFoundException {

        return new CsvToBeanBuilder(new FileReader(filePath)).withType(valueType).build().parse();

    }

}
