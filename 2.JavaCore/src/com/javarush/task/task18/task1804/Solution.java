package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        int bytes[] = new int[256];

        while (fis.available() > 0)
            bytes[fis.read()]++;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < min && bytes[i] != 0)
                min = bytes[i];
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min)
                System.out.print(i + " ");
        }

        reader.close();
        fis.close();
    }
}
