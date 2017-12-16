package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        copyWordsWithDigits(fileReader, fileWriter);

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public static void copyWordsWithDigits(BufferedReader fileReader, BufferedWriter fileWriter) throws IOException {
        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");

            for (String word : words) {
                if (word.matches("^.*\\d.*$"))
                    fileWriter.write(word + " ");
                /*boolean containsDigits = false;

                for (char character : word.toCharArray()) {
                    if (Character.isDigit(character)) {
                        containsDigits = true;
                        break;
                    }
                }*/
            }
        }
    }
}
