package com.istargazer.commonutils.file.mht.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MHTHeader {
    private List<String> headers = new ArrayList<>();

    private String boundary;

    public MHTHeader addData(String from) {
        this.headers.add(from);
        return this;
    }

    public MHTHeader setHeaders(String[] headers) {
        this.headers = Arrays.asList(headers);
        return this;
    }
    /**
     * 获取数据
     * @return
     */
    public List<String> getHeader() {
        return headers;
    }

    public String[] getHeaders(){
        return headers.toArray(new String[0]);
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }
}
