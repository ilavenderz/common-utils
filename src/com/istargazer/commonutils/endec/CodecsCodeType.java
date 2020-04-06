package com.istargazer.commonutils.endec;

public enum CodecsCodeType {

    QuotedPrintable(1,"QuotedPrintable"),
    BASE64(2,"BASE64");


    int code;
    String desc;
    CodecsCodeType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
