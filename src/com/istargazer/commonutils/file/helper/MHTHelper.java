package com.istargazer.commonutils.file.helper;

import com.istargazer.commonutils.file.FileType;
import com.istargazer.commonutils.file.mht.entity.IMHTConstants;
import com.istargazer.commonutils.file.mht.entity.MHTContent;
import com.istargazer.commonutils.file.mht.entity.MHTFile;
import com.istargazer.commonutils.file.mht.entity.MHTHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MHTHelper {

    public static MHTFile parser(BufferedReader reader) throws IOException {
        MHTFile file = MHTFile.createNewMHTFile();
        MHTHeader header = getHeader(reader);
        file.addHeader(header);
        file.addContents(getContents(reader,header.getBoundary()));
        return file;
    }

    /**
     * Gives you the header
     * @param reader
     * @return
     * @throws IOException
     */
    public static MHTHeader getHeader(BufferedReader reader) throws IOException {
        MHTHeader header = new MHTHeader();
        String line = "";
        String lineContent = "";
        while (null != (line = reader.readLine())) {
            lineContent = line.trim();
            if(lineContent.startsWith(IMHTConstants.BOUNDARY)) {
                header.setBoundary(lineContent.substring(lineContent.indexOf("\"") + 1, lineContent.lastIndexOf("\"")));
            }
            header.addData(line);
            if(lineContent.contains(header.getBoundary())) {
                break;
            }
        }
        return header;
    }

    private static List<MHTContent> getContents(BufferedReader reader,String boundary) throws IOException {
        List<MHTContent> contents = new ArrayList<>();
        String line = "";
        String lineContent = "";
        MHTContent content = new MHTContent();
        while (null != (line = reader.readLine())) {
            lineContent = line.trim();

            if(lineContent.contains(IMHTConstants.CONTENT_LOCATION)){
                content.setLocation(line);
            } else if(lineContent.contains(IMHTConstants.CONTENT_TRANSFER_ENCODING)) {
                content.setEncoding(line);
            } else if(lineContent.contains(IMHTConstants.CONTENT_TYPE)) {
                content.setType(line);
                content.setFileType(getFileType(lineContent));
            } else if(lineContent.contains(IMHTConstants.CHAR_SET)) {
                content.setCharset(line);
            } else if("".equals(lineContent)){
                content.addContent("\n");
                while (null != (line = reader.readLine())) {
                    content.addContent(line);
                    if(line.contains(boundary)){
                        content.addContent(line);
                        break;
                    }
                }
                contents.add(content);
                content = new MHTContent();
            }

        }
        return contents;
    }

    private static FileType getFileType(String line) {
        for (FileType type : FileType.values()) {
            if(line.contains(type.getDesc())){
                return type;
            }
        }
        return FileType.TEXT;
    }
}
