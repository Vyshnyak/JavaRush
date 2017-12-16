package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileFromName;

        while (!(fileFromName = reader.readLine()).equals("exit")) {
            new ReadThread(fileFromName).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (InputStream fileInputStream = new BufferedInputStream(new FileInputStream(getName()))) {
                int[] byteArray = new int[256];

                int oneByte;
                while ((oneByte = fileInputStream.read()) != -1) {
                    byteArray[oneByte]++;
                }

                int mostFreqByte = 0;
                for (int i = 1; i < byteArray.length; i++) {
                    if (byteArray[i] > byteArray[mostFreqByte])
                        mostFreqByte = i;
                }

                resultMap.put(getName(), mostFreqByte);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
