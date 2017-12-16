package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num_a = Integer.parseUnsignedInt(reader.readLine());
        int num_b = Integer.parseUnsignedInt(reader.readLine());

        if (num_a < 1 || num_b < 1)
            throw new NumberFormatException();

        System.out.println(getGreatestCommonDivisor(num_a, num_b));
    }

    static int getGreatestCommonDivisor(int a, int b) {
        if (b == 0) return a;

        return getGreatestCommonDivisor(b, a % b);
    }
}
