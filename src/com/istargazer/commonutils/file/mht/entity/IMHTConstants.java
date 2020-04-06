package com.istargazer.commonutils.file.mht.entity;

public interface IMHTConstants {
    // header
    String FROM = "From";
    String SUBJECT = "Subject";
    String DATE = "Date";
    String MIME_VERSION = "MIME_Version";
    String TYPE = "type";
    String BOUNDARY = "boundary";
    // content
    String CHAR_SET = "charset";
    String CONTENT_TYPE = "Content-Type";
    String CONTENT_ID = "Content-ID";
    String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    String CONTENT_LOCATION = "Content-Location";

    // encoding type
    String CONTENT_TRANSFER_ENCODING_QUOTED_PRINTABLE = "Quoted-printable";
    String CONTENT_TRANSFER_ENCODING_BASE64 = "base64";

    String UTF8_BOM = "=EF=BB=BF";

    String UTF16_BOM1 = "=FF=FE";
    String UTF16_BOM2 = "=FE=FF";
}
