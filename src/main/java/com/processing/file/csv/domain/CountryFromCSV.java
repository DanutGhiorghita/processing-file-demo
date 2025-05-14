package com.processing.file.csv.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CountryFromCSV {

    @CsvBindByName
    String name;

    @CsvBindByName
    String code;

}
