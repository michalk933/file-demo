package com.example.filedemo.properties;


public enum FtpProperty {

    path("/Users/michalkuchciak/IdeaProjects/file-demo/ftp/");

    private String pathFtp;

    FtpProperty(String pathFtp){
        this.pathFtp = pathFtp;
    }

    public String path(){
        return pathFtp;
    }
}
