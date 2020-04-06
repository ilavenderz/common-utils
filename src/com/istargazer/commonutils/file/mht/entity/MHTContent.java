package com.istargazer.commonutils.file.mht.entity;

import com.istargazer.commonutils.file.FileType;

import java.util.List;

public class MHTContent {
    private String type; // type
    private String charset; // char set
    private String encoding; //
    private String location;
    private StringBuilder lines;
    private String boundary;

    private FileType fileType;

    public MHTContent() {
        this.lines = new StringBuilder();
    }

    public MHTContent type(String type) {
        this.setType(type);
        return this;
    }

    public MHTContent addContent(String content) {
        this.lines.append(content);
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StringBuilder  getLines() {
        return lines;
    }

    public void setLines(StringBuilder lines) {
        this.lines = lines;
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public StringBuilder getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(location).append(encoding).append(type);
        if(null != charset && !"".contains(charset.trim())) {
            sb.append(charset);
        }
        sb.append("\n");
        sb.append(lines);
        sb.append(boundary);
        return sb;
    }
}
