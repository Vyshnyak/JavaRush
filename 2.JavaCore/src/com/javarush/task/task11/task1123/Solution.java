package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) throws Exception {

        // create an array of integer numbers and initialize it with 10 numbers
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        // get min and max numbers from array and put those in object of class Pair
        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        // print out the min and max numbers
        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    /*
     * searches for minimum and maximum numbers in array.
     * returns a new object with parameters of min and max numbers.
     */
    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {

        // return the object with null parameters if array is null or it's length equals 0
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //Напишите тут ваше решение

        // declare variables to store min and max numbers
        int min = 0;
        int max = 0;

        // get minimum and maximum numbers from an array
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] < array[min])
                min = i;
            else if (array[i] > array[max])
                max = i;
        }

        return new Pair<Integer, Integer>(array[min], array[max]);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
