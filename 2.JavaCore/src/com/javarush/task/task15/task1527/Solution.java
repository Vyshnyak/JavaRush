package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        // cut off left side substring up to '?' char;
        String subString = s.substring(s.indexOf('?') + 1);

        // splits up substring to substrings between '&' and puts them into array
        String[] array = subString.split("[&]");

        // prints parameters without values
        for (String str : array) {
            if (str.contains("="))
                System.out.print(str.substring(0, str.indexOf('=')) + " ");
            else
                System.out.print(str + " ");
        }

        System.out.println();

        // prints values of parameter "obj"
        for (String str : array) {
            if (str.contains("obj")) {
                try {
                    alert(Double.parseDouble(str.substring(str.indexOf('=') + 1)));
                }
                catch (NumberFormatException e) {
                    alert(str.substring(str.indexOf('=') + 1));
                }
            }
        }

        /*int startInd = s.indexOf('?', 0);
        int endInd = s.indexOf('&', startInd);

        String subString;

        while (startInd != -1) {
            subString = s.substring(startInd + 1, endInd);

            if (subString.contains("obj")) {
                parameters.add(subString.substring(0, subString.indexOf('=')));
                values.add(subString.substring(subString.indexOf('=') + 1));
            }
            else {
                if (subString.contains("="))
                    parameters.add(subString.substring(0, subString.indexOf('=')));
                else
                    parameters.add(subString);
            }

            startInd = s.indexOf('&', endInd);
            endInd = s.indexOf('&', startInd + 1);

            if (endInd == -1)
                endInd = s.length();
        }

        for (String param : parameters)
            System.out.print(param + " ");

        System.out.println();

        for (String value : values) {
            try {
                alert(Double.parseDouble(value));
            }
            catch (NumberFormatException e) {
                alert(value);
            }
        }*/
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
