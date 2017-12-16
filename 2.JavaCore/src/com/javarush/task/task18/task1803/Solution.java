package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (fis.available() > 0) {
            int b = fis.read();
            if (map.containsKey(b))
                map.put(b, map.get(b) + 1);
            else
                map.put(b, 1);
        }

        int maxRepeatsValue = 0;

        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue() > maxRepeatsValue)
                maxRepeatsValue = num.getValue();
        }

        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue().equals(maxRepeatsValue))
                System.out.print(num.getKey() + " ");
        }

        reader.close();
        fis.close();
    }
}
