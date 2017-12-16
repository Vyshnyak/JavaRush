package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
        TreeMap<Character, Integer> charFrequancyMap = new TreeMap<Character, Integer>();

        int oneByte;
        while ((oneByte = inputStream.read()) != -1) {
            if (charFrequancyMap.containsKey((char) oneByte))
                charFrequancyMap.put((char) oneByte, charFrequancyMap.get((char) oneByte) + 1);
            else
                charFrequancyMap.put((char) oneByte, 1);
        }

        for(Map.Entry<Character, Integer> pair : charFrequancyMap.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());

        inputStream.close();

        /*ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        byte[] ascii = new byte[128];

        int oneByte;
        while ((oneByte = inputStream.read()) != -1) {
            arrayOutputStream.write(oneByte);
            ascii[oneByte]++;
        }

        byte[] bytes = arrayOutputStream.toByteArray();
        Arrays.sort(bytes);

        for (byte aByte : bytes)
            System.out.printf("%c %d\n", aByte, ascii[aByte]);

        inputStream.close();
        arrayOutputStream.close();*/
    }
}
