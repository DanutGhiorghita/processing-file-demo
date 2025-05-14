package com.processing.file;

import com.processing.file.csv.domain.CountryFromCSV;
import com.processing.file.csv.parser.CSVParser;
import com.processing.file.json.domain.CountryFromJson;
import com.processing.file.json.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String COUNTRIES_CSV_PATH = "src/main/resources/csv/countries.csv";
    private static final String COUNTRIES_JSON_PATH = "src/main/resources/json/countries.json";

    public static void main(String[] args) {
        try {
            final List<CountryFromCSV> countries = CSVParser.read(CountryFromCSV.class, COUNTRIES_CSV_PATH);
            final List<CountryFromJson> countriesJson = JSONParser.read(CountryFromJson.class, COUNTRIES_JSON_PATH);

            logger.info("-------------------------");
            logger.info("first country from csv: {}", countries.stream().findFirst().get());
            logger.info("first country name from json: {}", countriesJson.stream().findFirst().get().getName());
            logger.info("json format: {}", JSONParser.readAsTree(COUNTRIES_JSON_PATH));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }


    }
}