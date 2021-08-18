package com.misc.parsers;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@Component
public class HtmlWriter {
    Environment env;

    @Autowired
    public HtmlWriter(Environment env) {
        this.env = env;
    }

    @SneakyThrows
    public  void saveToFile(String jsonString, String fileName, String fileRoot) {
        String filePath = fileRoot + "/" + fileName + ".html";
        File f = new File(filePath);

        if(!f.exists()){
            f.createNewFile();
        }

        @Cleanup FileWriter fw = new FileWriter(f);
        @Cleanup BufferedWriter bw = new BufferedWriter(fw);
        bw.write(jsonString);
        bw.flush();


    }
}
