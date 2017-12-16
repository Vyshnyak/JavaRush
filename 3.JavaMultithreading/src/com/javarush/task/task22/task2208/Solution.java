package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            String pattern = "%s = '%s'";
            if (pair.getValue() != null) {
                if (stringBuilder.length() > 0)
                    stringBuilder.append(" and ");

                stringBuilder.append(String.format(pattern, pair.getKey(), pair.getValue()));
            }
        }

        return stringBuilder.toString();
    }
}
