package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        /*List<Employee> employeeList =
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 35),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));

        Collections.sort(employeeList, new CustomizedComparator<Employee>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        }));

        System.out.println(Arrays.toString(employeeList.toArray()));*/
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T> ... comparators) {
            this.comparators = comparators;
        }


        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }
}
