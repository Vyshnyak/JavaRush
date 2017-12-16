package com.javarush.task.task18.task1805;

import com.javarush.task.task17.task1711.Sex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        Set<Integer> bytes = new TreeSet<Integer>();

        while (fis.available() > 0)
            bytes.add(fis.read());

        for (Integer num : bytes) {
            System.out.print(num + " ");
        }

        /*ArrayList<Integer> byteList = new ArrayList<Integer>();

        while (fis.available() > 0) {
            int num = fis.read();

            if (!byteList.contains(num))
                byteList.add(num);
        }

        Collections.sort(byteList);

        for (Integer num : byteList) {
            System.out.print(num + " ");
        }*/

        reader.close();
        fis.close();
    }
}
