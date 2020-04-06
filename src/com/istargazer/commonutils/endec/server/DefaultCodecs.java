package com.istargazer.commonutils.endec.server;

import com.istargazer.commonutils.endec.Codecs;

import java.nio.charset.Charset;

public class DefaultCodecs implements Codecs {
    @Override
    public String encodeStr(String content, Charset charset) {
        return content;
    }

    @Override
    public String decodeStr(String content, Charset charset) {
        return content;
    }
}
