package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        int numOfComma = 0;

        while (fis.available() > 0) {
            int bytes = fis.read();

            if (bytes == 44)
                numOfComma++;
        }

        System.out.println(numOfComma);

        reader.close();
        fis.close();
    }
}
