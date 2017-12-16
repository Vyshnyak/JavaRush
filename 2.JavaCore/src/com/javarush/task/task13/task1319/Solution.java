package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        // variable to break the loop
        boolean isExit = false;

        // read the line from console and write it to the file
        while (!isExit) {
            String data = reader.readLine();
            writer.write(data + '\n');
            if ("exit".equals(data))
                isExit = true;
        }

        reader.close();
        writer.close();
    }
}
