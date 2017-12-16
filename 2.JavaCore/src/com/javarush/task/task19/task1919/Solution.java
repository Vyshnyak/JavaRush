package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();

        copyFromFileToMap(treeMap, reader);
        printList(treeMap);

        reader.close();
    }

    public static void copyFromFileToMap(Map<String, Double> treeMap, BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            if (treeMap.containsKey(data[0]))
                treeMap.put(data[0], treeMap.get(data[0]) + Double.parseDouble(data[1]));
            else
                treeMap.put(data[0], Double.parseDouble(data[1]));
        }
    }

    public static void printList(Map<String, Double> treeMap) {
        for (Map.Entry<String, Double> pair : treeMap.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
    }
}
