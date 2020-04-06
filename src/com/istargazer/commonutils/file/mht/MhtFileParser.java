package com.istargazer.commonutils.file.mht;

import com.istargazer.commonutils.file.FileType;
import com.istargazer.commonutils.file.helper.MHTHelper;
import com.istargazer.commonutils.file.mht.entity.MHTContent;
import com.istargazer.commonutils.file.mht.entity.MHTFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MhtFileParser {



    public static void main(String[] args) {
        File file = new File("d:\\temp\\t1.mht");
        try {
            MHTFile mhtFile = MHTHelper.parser(new BufferedReader(new FileReader(file)));

            List<MHTContent> list = new ArrayList<>();
            for(MHTContent content : mhtFile.getContents()){
                if(!content.getFileType().equals(FileType.TEXT_JAVASCRIPT)) {
                    list.add(content);
                }
                if(content.getFileType().equals(FileType.TEXT_HTML)) {
                    list.add(modifyHTML(content));
                }
            }
            mhtFile.setContents(list);

            Document document = Jsoup.parse(file,"utf8");
            document.select("script").remove();
            File des = new File("d:\\temp\\modify.mht");
            FileOutputStream fos = new FileOutputStream(des, false);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(document.html());
            osw.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MHTContent modifyHTML(MHTContent content) {

    }
}
