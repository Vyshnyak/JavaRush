package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileFromName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileFromName)));

        String line;

        while ((line = fileReader.readLine()) != null) {
            if (line.contains(args[0]))
                System.out.println(line);
        }

        reader.close();
        fileReader.close();
    }
}
