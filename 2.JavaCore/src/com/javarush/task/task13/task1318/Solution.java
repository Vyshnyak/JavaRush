package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileinputstream = new FileInputStream(reader.readLine());

        // read the each byte from file output it on the screen
        while (fileinputstream.available() > 0)
            System.out.print((char) fileinputstream.read());

        // move to a new line
        System.out.println();

        // close all threads
        fileinputstream.close();
        reader.close();
    }
}