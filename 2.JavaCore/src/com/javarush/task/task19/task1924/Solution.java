package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        printWithReplacingDigits(fileName);
    }

    public static void printWithReplacingDigits(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].matches("(\\d|10|11|12)")) {
                    words[i] = words[i].replace(words[i], map.get(Integer.parseInt(words[i])));
                }

                if (i < words.length - 1)
                    System.out.print(words[i] + " ");
                else
                    System.out.println(words[i]);
            }
        }
        fileReader.close();
    }
}
