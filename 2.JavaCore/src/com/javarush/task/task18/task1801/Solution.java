package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileInputStream = new FileInputStream(reader.readLine());

        int maxByte = 0;

        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();

            if (currentByte > maxByte)
                maxByte = currentByte;
        }

        System.out.println(maxByte);
        reader.close();
        fileInputStream.close();
    }
}
