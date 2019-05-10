package com.example.filedemo.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FileDataGenerate {

    // name without type. 20191212_123
    private String name;

    // account number. 123
    private String accountNumber;

    // loacl date yyyy-MM-dd
    private LocalDate generateDate;

    // PDF, MT904
    private FileType fileType;


}
