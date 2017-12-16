package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader.close();

        printReversedLines(fileName);
    }

    public static void printReversedLines(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = fileReader.readLine()) != null) {
            stringBuilder.append(line);
            System.out.println(stringBuilder.reverse());
            stringBuilder.delete(0, stringBuilder.length());
        }

        fileReader.close();
    }
}
