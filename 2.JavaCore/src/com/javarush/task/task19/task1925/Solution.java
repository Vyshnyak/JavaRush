package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        copyWordsLongerSixChars(fileReader, fileWriter);

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public static void copyWordsLongerSixChars(BufferedReader fileReader, BufferedWriter fileWriter) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = fileReader.readLine()) != null) {

            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) {
                    stringBuilder.append(words[i] + ",");
                }
            }
        }

        String newLine = stringBuilder.toString().replaceAll(",$", "");
        fileWriter.write(newLine);
    }
}
