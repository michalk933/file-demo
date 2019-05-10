package com.example.filedemo.controller;

import com.example.filedemo.dto.FileDataGenerate;
import com.example.filedemo.dto.FileType;
import com.example.filedemo.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class GenerateControler {

    @Autowired
    GenerateService generateService;

    @GetMapping
    public void generateFile(){

        FileDataGenerate build = FileDataGenerate.builder()
                .accountNumber("123")
                .fileType(FileType.PDF)
                .generateDate(LocalDate.of(2019, 12, 12))
                .name("20191212_123")
                .build();

        generateService.generate(build);
    }


}
