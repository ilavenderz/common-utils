package com.istargazer.commonutils.endec.server;

import com.istargazer.commonutils.endec.Codecs;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class QuotedPrintableCodecs implements Codecs {
    @Override
    public String encodeStr(String content, Charset charset) {
        return null;
    }

    @Override
    public String decodeStr(String content, Charset charset) {
        if (content == null) {
            return null;
        }
        try {
            //str = str.replaceAll("=\n", "");//??
            byte[] bytes = content.getBytes(StandardCharsets.US_ASCII);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i];
                if (b == '=') {
                    int u = Character.digit((char) bytes[++i], 16);
                    int l = Character.digit((char) bytes[++i], 16);
                    if (u == -1 || l == -1) {//??
                        continue;
                    }
                    buffer.write((char) ((u << 4) + l));
                } else {
                    buffer.write(b);
                }
            }
            return buffer.toString(charset);
        }
        catch (Exception e) {
            e.printStackTrace();
            return content;
        }
    }
}
