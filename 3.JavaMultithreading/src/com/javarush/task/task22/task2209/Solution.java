package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String[] words = readWordsFromFile(fileName);
        Arrays.sort(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static String[] readWordsFromFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = fileReader.readLine()) != null) {
            if (stringBuilder.length() > 0)
                stringBuilder.append(' ');
            stringBuilder.append(line);
        }
        fileReader.close();

        return stringBuilder.toString().split(" ");
    }

    public static StringBuilder getLine(String... words) {

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(words[i].length() - 1) == words[j].toLowerCase().charAt(0)) {
                    swap(words, i + 1, j);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        fromArrayToString(words, result);

        return result;
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void fromArrayToString(String[] words, StringBuilder result) {
        for (String word : words) {
            result.append(word);
            result.append(' ');
        }
    }
}