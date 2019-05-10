package com.example.filedemo.service;

import com.example.filedemo.dto.PathData;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    public void createFileLck(PathData pathData) {
        Path pathToFile = Paths.get(pathData.getFillPathWithName(pathData.getPath(), pathData.getFileNameLck()));
        try {
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rename(PathData pathData) {
        File fileLck = new File(pathData.getFillPathWithName(pathData.getPath(), pathData.getFileNameLck()));
        File fileNew = new File(pathData.getFillPathWithName(pathData.getPath(), pathData.getFileNameWithType()));
        fileLck.renameTo(fileNew);
    }

    public void saveFileWithFtp(InputStream inputStream, PathData pathData) {
        try {
            File targetFile = new File(pathData.getFillPathWithName(pathData.getPath(), pathData.getFileNameLck()));

            Files.copy(
                    inputStream,
                    targetFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            IOUtils.closeQuietly(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
