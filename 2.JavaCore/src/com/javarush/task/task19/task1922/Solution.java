package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        printLinesFromFile(fileName);
    }

    public static void printLinesFromFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = fileReader.readLine()) != null) {
            int concurrences = 0;

            for (String word : words) {
                if (line.contains(word))
                    concurrences++;
            }

            if (concurrences == 2)
                System.out.println(line);
        }

        fileReader.close();
    }
}
