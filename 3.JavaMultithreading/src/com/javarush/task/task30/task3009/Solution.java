package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> radixSet = new HashSet<>();
        if (number.matches("[1-9]\\d*")) {
            for (int i = 2; i <= 36; i++) {
                try {
                    Integer digitNumber = Integer.valueOf(number);
                    String convertedNumber = getConvertedNumber(digitNumber, i);
                    if (convertedNumber.equals(new StringBuilder(convertedNumber).reverse().toString())) {
                        radixSet.add(i);
                    }
                } catch (NumberFormatException e) {
                    /*NOP*/
                }
            }
        }
        return radixSet;
    }

    private static String getConvertedNumber(int number, int radix) {
        if (number == 0) {
            return "";
        }
        int reminder = number % radix;
        return getConvertedNumber(number / radix, radix) + (reminder < 10 ? String.valueOf(number % radix) : String.valueOf((char) (reminder + 55)));
    }


}