package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static StringBuilder htmlFile = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        readFromHtml(fileName);
        findAndPrintTag(args[0], htmlFile.toString(), 0);
    }

    public static void readFromHtml(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = fileReader.readLine()) != null)
            htmlFile.append(line);

        fileReader.close();
    }
    public static void findAndPrintTag(String tag, String string, int startInd) {
        Pattern pattern = Pattern.compile("<" + tag + ".*?>.*?(<" + tag + ".*?>.*?</" + tag + ">.*?)*</" + tag + ">");
        Matcher matcher = pattern.matcher(string);

        matcher.region(startInd, string.length());

        while (matcher.find()) {
            System.out.println(matcher.group());
            findAndPrintTag(tag, matcher.group(), 1);
        }
    }
}
