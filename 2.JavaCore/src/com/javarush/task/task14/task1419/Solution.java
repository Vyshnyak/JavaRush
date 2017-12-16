package com.javarush.task.task14.task1419;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int nums[] = new int[1];
            System.out.println(nums[2]);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String name = null;
            FileReader fileReader = new FileReader(name);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Class.forName("Maxim");

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] buffer = new int[-1];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String num = "3k";
            int number = Integer.parseInt(num);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String string = "name";

            string.charAt(6);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object string = new String("name");
            Integer num = (Integer) string;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<Integer>();

            list.get(1);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object[] num = new Integer[2];
            num[1] = 4.4;
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
