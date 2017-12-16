package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        int length = numLength(N);
        List<Long> list = ArmstrongNumbersMultiSetLong.generate(length);
        /*long[][] degree = new long[10][numLength(N) + 1];

        fill2DArray(degree);

        for (long i = 1; i < N; i++) {
            int length = numLength(i);

            if (isNumSatisfying(i, length, degree))
                list.add(i);
        }*/

        return fromListToArray(list);
    }

    /*public static void fill2DArray(long[][] degree) {
        for (int i = 1; i < degree.length; i++) {
            for (int j = 1; j < degree[i].length; j++)
                degree[i][j] = (long) Math.pow(i, j);
        }
    }*/

    public static int numLength(long num) {
        int length = 0;

        while (num > 0) {
            num /= 10;
            length++;
        }

        return length;
    }

    /*
    public static boolean isNumSatisfying(long num, int numLength, long[][] degree) {
        long primaryNum = num;
        long result = 0;

        for (int j = 0; j < numLength; j++) {
            int subNum = (int) num % 10;

            if (subNum < 2)
                result += subNum;
            else
                result += degree[subNum][numLength];

            if (result > primaryNum)
                return false;

            num = num / 10;
        }

        return result == primaryNum;
    }*/

    public static long[] fromListToArray(List<Long> list) {
        long[] array = new long[list.size()];

        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        return array;
    }

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        long[] nums = getNumbers(Long.MAX_VALUE);
        long after = System.currentTimeMillis();
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(after - before);
        System.out.println(usedBytes / 1048576);
        System.out.println(Arrays.toString(nums));
    }
}
