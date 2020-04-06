package com.istargazer.commonutils.file;

public enum FileType {


    TEXT(1,"text"),
    TEXT_HTML(2,"text/html"),
    TEXT_CSS(3,"text/css"),
    TEXT_JAVASCRIPT(4,"text/javascript"),
    IMAGE_GIF(101,"image/gif"),
    IMAGE_JPEG(102,"image/jpeg"),
    MULTIPART_RELATED(1001,"multipart/related");

    int type;
    String desc;

    FileType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }


    public String getDesc() {
        return desc;
    }

}
