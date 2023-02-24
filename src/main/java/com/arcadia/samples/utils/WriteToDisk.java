package com.arcadia.samples.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ganaranjo
 */
public class WriteToDisk {

    String pathToFile = "";
    boolean result = false;

    public WriteToDisk(String fileName) {
        pathToFile = "~/" + fileName;
    }

    public boolean WriteFileToDisk(String buffer, boolean append) {

        try {
            File file = new File(pathToFile);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(file, append);

            fileWriter.write(buffer);
            fileWriter.write("\r\n\r\n");
            fileWriter.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
