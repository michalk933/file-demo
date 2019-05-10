package com.example.filedemo.properties;

public enum LocalDataPropertiy {

    paht("/Users/michalkuchciak/IdeaProjects/file-demo/storage");

    private String pathFile;

    LocalDataPropertiy(String pathFile){
        this.pathFile = pathFile;
    }

    public String path(){
        return pathFile;
    }

}
