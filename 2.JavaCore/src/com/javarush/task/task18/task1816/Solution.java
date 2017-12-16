package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int alphaChars = 0;

        int oneByte;

        while ((oneByte = fileInputStream.read()) != -1) {
            if (oneByte > 64 && oneByte < 123)
                alphaChars++;
        }

        System.out.println(alphaChars);

        fileInputStream.close();
    }
}
