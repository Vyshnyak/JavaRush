package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String, String> map = new HashMap<String, String>();

        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;

            String family = reader.readLine();
            if (family.isEmpty()) break;

            map.put(city, family);
        }
        /*List<String> addresses = new ArrayList<String>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.add(family);
        }*/

        //read home number
        String city = reader.readLine();

        if (map.containsKey(city))
        {
            System.out.println(map.get(city));
        }
        /*int houseNumber = Integer.parseInt(reader.readLine());

        if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familySecondName = addresses.get(houseNumber);
            System.out.println(familySecondName);
        }*/
    }
}
