package com.example.filedemo.service;

import com.example.filedemo.dto.Counter;
import com.example.filedemo.dto.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GenerateNameService {

    private final static String communicatType = "M20901";

    private final static String dateFormat = "yyMMdd";

    private final static String patternName = "%1$s%2$s%3$s.%4$s";

    @Autowired
    Counter counter;

    public String getNameForEcms(LocalDate date, FileType fileType) {
        String format = date.format(DateTimeFormatter.ofPattern(dateFormat));
        return String.format(patternName, communicatType, format, counter.getNextValueFormatECMS(), fileType);
    }


}
