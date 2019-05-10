package com.example.filedemo.service;

import com.example.filedemo.properties.FtpProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Slf4j
@Service
public class FtpService {

    public void open() {
        log.info("Open connect to FTP");
    }

    public void close() {
        log.info("Close connect to FTP");
    }

    public InputStream getFileFromFtp(String fileName) {
        String path = FtpProperty.path.path();
        File initialFile = new File(String.format("%1$s%2$s", path, fileName));
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileInputStream;
    }


}
