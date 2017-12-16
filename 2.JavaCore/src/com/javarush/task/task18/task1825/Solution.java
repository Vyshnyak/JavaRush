package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> fileNames = new TreeSet<String>();

        String fileFromName = null;

        while (true) {
            String fileName = reader.readLine();

            if (fileName.equals("end"))
                break;

            fileFromName = fileName;
            fileNames.add(fileFromName);
        }

        String[] fileToName = fileFromName.split("\\.part\\d+$");

        InputStream fileInStr;
        OutputStream fileOutStr = new BufferedOutputStream(new FileOutputStream(fileToName[0]));

        for (String fileName : fileNames){
            fileInStr = new BufferedInputStream(new FileInputStream(fileName));

            byte[] buffer = new byte[fileInStr.available()];

            while (true) {
                int count = fileInStr.read(buffer);
                if (count == -1) {
                    fileInStr.close();
                    break;
                }

                fileOutStr.write(buffer, 0, count);
            }
        }
        fileOutStr.close();
    }
}
