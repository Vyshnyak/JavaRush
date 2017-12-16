package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        String s = "String";
        ArrayList<String> array = new ArrayList<String>();

        for (int i = 0; i < 10; i++)
            array.add(s);

        ArrayList<String>[] arrayLists = new ArrayList[10];

        for (int i = 0; i < arrayLists.length; i++)
            arrayLists[i] = array;

        //the solution of another student
        /*ArrayList<String>[] arrayLists = new ArrayList[10];

        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
            arrayLists[i].add("list" + " " + i);
            arrayLists[i].add("list" + " " + i + "." + 1);
        }*/

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}