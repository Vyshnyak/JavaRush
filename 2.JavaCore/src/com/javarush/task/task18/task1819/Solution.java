package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = reader.readLine();
        String file2Name = reader.readLine();

        InputStream file1InputStream = new BufferedInputStream(new FileInputStream(file1Name));
        InputStream file2InputStream = new BufferedInputStream(new FileInputStream(file2Name));
        OutputStream file1OutputStream = new BufferedOutputStream(new FileOutputStream(file1Name));

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int oneByte;

        while ((oneByte = file1InputStream.read()) != -1)
            buffer.write(oneByte);

        while ((oneByte = file2InputStream.read()) != -1)
            file1OutputStream.write(oneByte);

        file1OutputStream.write(buffer.toByteArray());

        file1InputStream.close();
        file2InputStream.close();
        file1OutputStream.flush();
        file1OutputStream.close();
        buffer.flush();
        buffer.close();
    }
}
