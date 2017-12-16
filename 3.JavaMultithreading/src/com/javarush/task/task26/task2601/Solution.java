package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] arrayCopy = array.clone();
        Arrays.sort(arrayCopy);

        int middle = (arrayCopy.length - 1) / 2;
        int median;

        if ((arrayCopy.length % 2) != 0) {
            median = arrayCopy[middle];
        } else {
            median = (arrayCopy[middle] + arrayCopy[middle + 1]) / 2;
        }

        Arrays.sort(arrayCopy, (o1, o2) -> {
            int distance1 = o1 - median;
            int distance2 = o2 - median;

            int result = Integer.compare(Math.abs(distance1), Math.abs(distance2));

            if (result != 0) {
                return result;
            }

            return Integer.compare(o1, o2);
        });

        return arrayCopy;
    }
}
