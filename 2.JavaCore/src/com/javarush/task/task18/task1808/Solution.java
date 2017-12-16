package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream file1In = new FileInputStream(file1);
        FileOutputStream file2Out = new FileOutputStream(file2);
        FileOutputStream file3Out = new FileOutputStream(file3);

        byte f2bytes[] = new byte[file1In.available() - (file1In.available() / 2)];
        byte f3bytes[] = new byte[file1In.available() / 2];

        if (file1In.available() > 0) {
            int countf2 = file1In.read(f2bytes);
            int countf3 = file1In.read(f3bytes);
            file2Out.write(f2bytes, 0, countf2);
            file3Out.write(f3bytes, 0, countf3);
        }

        reader.close();
        file1In.close();
        file2Out.flush();
        file2Out.close();
        file3Out.flush();
        file3Out.close();
    }
}
