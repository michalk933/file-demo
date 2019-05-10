package com.example.filedemo.service;


import com.example.filedemo.dto.FileDataGenerate;
import com.example.filedemo.dto.PathData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class GenerateService {

    @Autowired
    FileService fileService;

    @Autowired
    EcmsService ecmsService;

    @Autowired
    GenerateNameService generateNameService;

    @Autowired
    FtpService ftpService;

    public void generate(FileDataGenerate fileDataGenerate){

        PathData pathData = new PathData(fileDataGenerate);

        //create lck
        fileService.createFileLck(pathData);

        //create name ECMS
        String nameForEcms = generateNameService.getNameForEcms(fileDataGenerate.getGenerateDate(), fileDataGenerate.getFileType());

        //work ECMS
        ecmsService.mockWorkSCMS(nameForEcms);

        //ftp
        ftpService.open();
        InputStream fileFromFtp = ftpService.getFileFromFtp(nameForEcms);
        ftpService.close();

        // save file LCK from FTP
        fileService.saveFileWithFtp(fileFromFtp, pathData);

        //rename from LCK to Type
        fileService.rename(pathData);

    }


}
