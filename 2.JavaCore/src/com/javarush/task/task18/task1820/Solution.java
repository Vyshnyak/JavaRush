package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileFromName = reader.readLine();
        String fileToName = reader.readLine();

        InputStream fileFromInputStream = new FileInputStream(fileFromName);
        PrintStream fileToOutputStream = new PrintStream(new FileOutputStream(fileToName));

        StringBuilder stringBuilder = new StringBuilder();

        int oneByte;
        while ((oneByte = fileFromInputStream.read()) != -1)
            stringBuilder.append((char) oneByte);

        String[] doubles = stringBuilder.toString().split(" ");

        for (String aDouble : doubles)
            fileToOutputStream.printf("%d ", (int) Math.round(Double.parseDouble(aDouble)));

        reader.close();
        fileFromInputStream.close();
        fileToOutputStream.flush();
        fileToOutputStream.close();
    }
}
