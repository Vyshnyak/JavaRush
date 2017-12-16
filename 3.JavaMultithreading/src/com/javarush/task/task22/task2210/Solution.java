package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] tokens = new String[tokenizer.countTokens()];

        for (int i = 0; tokenizer.hasMoreTokens(); i++)
            tokens[i] = tokenizer.nextToken();

        return tokens;
    }
}
