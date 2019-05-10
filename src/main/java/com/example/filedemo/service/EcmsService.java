package com.example.filedemo.service;

import com.example.filedemo.properties.FtpProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class EcmsService {

    public void mockWorkSCMS(String nameFileForECMS) {
        log.info("Work ECMS");
        try {
            String path = FtpProperty.path.path();
            Path newFilePath = Paths.get(String.format("%1$s%2$s", path, nameFileForECMS));
            Files.createFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("End work ECMS");
    }

}
