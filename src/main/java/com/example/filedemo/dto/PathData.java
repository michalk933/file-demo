package com.example.filedemo.dto;

import com.example.filedemo.properties.LocalDataPropertiy;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PathData {

    // /Users/michalkuchciak/IdeaProjects/file-demo/storage/2019/12/12/123/
    private String path;

    // name without type
    private String name;

    // type
    private FileType fileType;

    public PathData(FileDataGenerate fileDataGenerate) {
        this.path = generatePath(fileDataGenerate.getGenerateDate(), fileDataGenerate.getAccountNumber());
        this.name = fileDataGenerate.getName();
        this.fileType = fileDataGenerate.getFileType();
    }

    //name.LCK
    public String getFileNameLck(){
        return String.format("%1$s.LCK", this.name);
    }

    //name.PDF
    public String getFileNameWithType(){
        return String.format("%1$s.%2$s", this.name, this.fileType);
    }

    // /Users/michalkuchciak/IdeaProjects/file-demo/storage/2019/12/12/123/name.PDF/LCK
    public String getFillPathWithName(String pahtFull, String fileName){
        return String.format("%1$s%2$s", pahtFull, fileName);
    }

    // /Users/michalkuchciak/IdeaProjects/file-demo/storage/2019/12/12/123/  generate path
    private String generatePath(LocalDate localDate, String accountNumber) {
        return String.format("%1$s/%2$s/%3$s/%4$s/%5$s/", LocalDataPropertiy.paht.path(), localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), accountNumber);
    }
}
