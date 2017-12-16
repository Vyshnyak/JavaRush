package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        copyWithoutPunctuation(fileReader, fileWriter);

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public static void copyWithoutPunctuation(BufferedReader fileReader, BufferedWriter fileWriter) throws IOException {
        CharArrayWriter arrayWriter = new CharArrayWriter();

        while (fileReader.ready())
            arrayWriter.write(fileReader.read());

        fileWriter.write(arrayWriter.toString().replaceAll("\\W", ""));
    }
}
