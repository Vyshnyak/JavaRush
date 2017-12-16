package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileFromName = reader.readLine();
        String fileToName = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileFromName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileToName));

        int oneChar;
        int count = 0;
        while ((oneChar = fileReader.read()) != -1) {
            if (count % 2 == 1)
                fileWriter.write(oneChar);
            count++;
        }

        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
