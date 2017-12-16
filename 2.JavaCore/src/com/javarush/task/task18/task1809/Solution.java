package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1name = reader.readLine();
        String file2name = reader.readLine();

        FileInputStream file1In = new FileInputStream(file1name);
        FileOutputStream file2Out = new FileOutputStream(file2name);

        byte bytes[] = new byte[file1In.available()];
        byte reversedBytes[] = new byte[file1In.available()];

        if (file1In.available() > 0) {
            int count = file1In.read(bytes);

            for (int i = 0; i < bytes.length; i++)
                reversedBytes[(reversedBytes.length - 1) - i] = bytes[i];

            file2Out.write(reversedBytes, 0, count);
        }

        reader.close();
        file1In.close();
        file2Out.flush();
        file2Out.close();
    }
}
