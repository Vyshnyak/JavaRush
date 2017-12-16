package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileFromName = reader.readLine();
        String fileToName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileFromName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToName));

        copyWithReplace(fileReader, fileWriter);

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public static void copyWithReplace(BufferedReader fileReader, BufferedWriter fileWriter) throws IOException {
        String line;
        while ((line = fileReader.readLine()) != null)
            fileWriter.write(line.replace(".", "!"));
    }
}
