package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        int spaces = 0;
        int allChars = 0;

        int oneByte;

        while ((oneByte = reader.read()) != -1) {
            if (oneByte == 32)
                spaces++;

            allChars++;
        }

        double ratio = ((double) spaces / allChars) * 100;

        System.out.printf("%,.2f", ratio);

        reader.close();
    }
}
