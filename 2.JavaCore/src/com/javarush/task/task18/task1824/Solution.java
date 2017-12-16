package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();
            try (InputStream fileInputStream = new BufferedInputStream(new FileInputStream(fileName))) {

            }
            catch (FileNotFoundException e ) {
                reader.close();
                System.out.println(fileName);
                return;
            }
        }
    }
}
