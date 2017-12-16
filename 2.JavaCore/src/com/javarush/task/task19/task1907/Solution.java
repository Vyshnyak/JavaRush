package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        CharArrayWriter charArray = new CharArrayWriter();

        readFullyToCharArray(fileReader, charArray);
        fileReader.close();

        String[] words;
        words = charArray.toString().split("\\bworld\\b");

        System.out.print(words.length - 1);
    }

    public static void readFullyToCharArray(BufferedReader fileReader, CharArrayWriter charArray) throws IOException {
        while (fileReader.ready()) {
            charArray.write(fileReader.read());
        }
    }
}
