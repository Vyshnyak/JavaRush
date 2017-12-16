package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        String file3Name = reader.readLine();

        OutputStream file1OutputStream = new BufferedOutputStream(new FileOutputStream(file1Name));
        InputStream file2InputStream = new BufferedInputStream(new FileInputStream(file2Name));
        InputStream file3InputStream = new BufferedInputStream(new FileInputStream(file3Name));

        int oneByte;

        while ((oneByte = file2InputStream.read()) != -1)
            file1OutputStream.write(oneByte);

        while ((oneByte = file3InputStream.read()) != -1)
            file1OutputStream.write(oneByte);

        reader.close();
        file1OutputStream.flush();
        file1OutputStream.close();
        file2InputStream.close();
        file3InputStream.close();
    }
}
