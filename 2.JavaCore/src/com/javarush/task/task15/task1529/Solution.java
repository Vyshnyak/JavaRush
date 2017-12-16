package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // initialize objects corresponding to entered object name
        try {
            String key = reader.readLine();
            if (key.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (key.equals("plane")) {
                try {
                    result = new Plane(Integer.parseInt(reader.readLine()));
                }
                catch (NumberFormatException e) {
                }
            }
        }
        catch (IOException e) {
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
