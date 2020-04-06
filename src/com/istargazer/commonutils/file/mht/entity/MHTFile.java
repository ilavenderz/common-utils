package com.istargazer.commonutils.file.mht.entity;

import java.util.ArrayList;
import java.util.List;

public class MHTFile {
    private MHTHeader header;
    private List<MHTContent> contents;

    private MHTFile(){
        this.header = new MHTHeader();
        this.contents = new ArrayList<>();
    };

    public static MHTFile createNewMHTFile() {
        return new MHTFile();
    }

    public MHTFile addHeader(MHTHeader header) {
        this.header = header;
        return this;
    }
    public MHTFile addHeader(String header) {
        this.header.addData(header);
        return this;
    }

    public MHTFile addContents(List<MHTContent> contents) {
        this.contents = contents;
        return this;
    }
    public MHTFile addContent(MHTContent content) {
        this.contents.add(content);
        return this;
    }

    public MHTHeader getHeader() {
        return header;
    }

    public void setHeader(MHTHeader header) {
        this.header = header;
    }

    public List<MHTContent> getContents() {
        return contents;
    }

    public void setContents(List<MHTContent> contents) {
        this.contents = contents;
    }
}
