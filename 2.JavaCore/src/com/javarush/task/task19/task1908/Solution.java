package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        copyDigits(fileReader, fileWriter);

        /*for (String num : numbers) {
            try {
                fileWriter.write(Integer.parseInt(num) + " ");
            }
            catch (NumberFormatException e) {
                *//*NOP*//*
            }
        }*/

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }

    public static void copyDigits(BufferedReader fileReader, BufferedWriter fileWriter) throws IOException {
        String line = fileReader.readLine();

        String[] numbers = line.split(" ");

        for (String num : numbers) {
            if (num.matches("^\\d+$"))
                fileWriter.write(num + " ");
        }
    }
}
