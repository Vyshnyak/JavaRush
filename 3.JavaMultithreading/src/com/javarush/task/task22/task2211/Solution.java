package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int aByte;

        while ((aByte = inputStream.read()) != -1) {
            byteArrayOutputStream.write(aByte);
        }

        byte[] buffer = byteArrayOutputStream.toByteArray();

        String string = new String(buffer);
        buffer = string.getBytes("Windows-1251");
        outputStream.write(buffer);

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}