package com.istargazer.commonutils.endec;

import com.istargazer.commonutils.endec.server.Base64Codecs;
import com.istargazer.commonutils.endec.server.DefaultCodecs;
import com.istargazer.commonutils.endec.server.QuotedPrintableCodecs;

public class CodecsAgent {

    public static Codecs getCodecs(CodecsCodeType type) {
        switch (type) {
            case QuotedPrintable:
                return new QuotedPrintableCodecs();
            case BASE64:
                return new Base64Codecs();
            default:
                return new DefaultCodecs();
        }
    }
}
