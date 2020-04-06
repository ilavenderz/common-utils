package com.istargazer.commonutils.endec;

import java.nio.charset.Charset;

public interface Codecs {

    String encodeStr(String content, Charset charset);

    String decodeStr(String content, Charset charset);
}
