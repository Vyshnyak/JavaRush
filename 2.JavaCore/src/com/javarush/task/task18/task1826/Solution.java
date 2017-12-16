package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStream fileInputStream = new BufferedInputStream(new FileInputStream(args[1]));
        OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(args[2]));

        int key = 0;

        if (args[0].equals("-e"))
            key = 2;
        else if (args[0].equals("-d"))
            key = -2;

        int oneByte;
        while ((oneByte = fileInputStream.read()) != -1)
            fileOutputStream.write(oneByte + key);

        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
