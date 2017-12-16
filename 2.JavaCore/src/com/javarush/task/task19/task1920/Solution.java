package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> salaryMap = new TreeMap<String, Double>();

        copyFromFileToMap(salaryMap, fileReader);
        printMaxWageWorkers(salaryMap);

        fileReader.close();
    }
    public static void copyFromFileToMap(Map<String, Double> salaryMap, BufferedReader fileReader) throws IOException {
        String list;

        while ((list = fileReader.readLine()) != null) {
            String[] salaryData = list.split(" ");

            if (salaryMap.containsKey(salaryData[0]))
                salaryMap.put(salaryData[0], salaryMap.get(salaryData[0]) + Double.parseDouble(salaryData[1]));
            else
                salaryMap.put(salaryData[0], Double.parseDouble(salaryData[1]));
        }
    }

    public static void printMaxWageWorkers (Map<String, Double> salaryMap) {
        double maxSalary = 0.0;

        for (Map.Entry<String, Double> pair : salaryMap.entrySet()) {
            if (maxSalary < pair.getValue())
                maxSalary = pair.getValue();
        }

        for (Map.Entry<String, Double> pair : salaryMap.entrySet()) {
            if (maxSalary == pair.getValue())
                System.out.println(pair.getKey());
        }
    }
}
