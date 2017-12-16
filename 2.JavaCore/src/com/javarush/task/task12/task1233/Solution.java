package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        //create and fill up the array with numbers
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        // pass the array in to function and return an object with pair of min num and its index
        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        // print out the minimum number and its index
        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {

        // return an empty object if array is null or its length equals 0
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код

        // declare a variable to store index of lowest number
        int min = 0;

        // search for the lowest number in array
        for (int i = 1; i < array.length; i++)
            min = array[i] < array[min] ? i : min;

        return new Pair<Integer, Integer>(array[min], min);
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
