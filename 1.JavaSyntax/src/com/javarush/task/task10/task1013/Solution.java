package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;

        public Human(String name, String lastName)
        {
            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, Human father)
        {
            this.name = name;
            this.sex = sex;
            this.father = father;
        }

        public Human(String name, int age, Human father)
        {
            this.name = name;
            this.age = age;
            this.father = father;
        }

        public Human(String name, String lastName, Human father)
        {
            this.name = name;
            this.lastName = lastName;
            this.father = father;
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, String lastName, int age, boolean sex, Human father, Human mother)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, String lastName, int age, boolean sex, Human father)
        {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.father = father;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }


    }
}
