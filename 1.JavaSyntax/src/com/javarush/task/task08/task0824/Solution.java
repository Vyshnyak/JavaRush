package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human child1 = new Human("Макс", true, 25);
        Human child2 = new Human("Игорь", true, 25);
        Human child3 = new Human("Марина", false, 14);
        Human mother = new Human("Люда", false, 44, child1, child2, child3);
        Human father = new Human("Олег", true, 49, child1, child2, child3);
        Human grandMother1 = new Human("Женя", false, 72, mother);
        Human grandMother2 = new Human("Таня", false, 78, father);
        Human grandFather1 = new Human("Толя", true, 75, mother);
        Human grandFather2 = new Human("Иван", true, 65, father);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(grandFather1);
        System.out.println(grandFather2);

        /*Human child1 = new Human();

        child1.name = "Макс";
        child1.sex = true;
        child1.age = 25;

        System.out.println(child1.toString());

        Human child2 = new Human();

        child2.name = "Игорь";
        child2.sex = true;
        child2.age = 25;

        System.out.println(child2.toString());

        Human child3 = new Human();

        child3.name = "Марина";
        child3.sex = false;
        child3.age = 14;

        System.out.println(child3.toString());

        Human mother = new Human();

        mother.name = "Люда";
        mother.sex = false;
        mother.age = 44;
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        System.out.println(mother.toString());

        Human father = new Human();

        father.name = "Олег";
        father.sex = true;
        father.age = 49;
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        System.out.println(father.toString());

        Human grandMother1 = new Human();

        grandMother1.name = "Женя";
        grandMother1.sex = false;
        grandMother1.age = 72;
        grandMother1.children.add(mother);

        System.out.println(grandMother1.toString());

        Human grandMother2 = new Human();

        grandMother2.name = "Таня";
        grandMother2.sex = false;
        grandMother2.age = 78;
        grandMother2.children.add(father);

        System.out.println(grandMother2.toString());

        Human grandFather1 = new Human();

        grandFather1.name = "Толя";
        grandFather1.sex = true;
        grandFather1.age = 75;
        grandFather1.children.add(mother);

        System.out.println(grandFather1.toString());

        Human grandFather2 = new Human();

        grandFather2.name = "Иван";
        grandFather2.sex = false;
        grandFather2.age = 65;
        grandFather2.children.add(father);

        System.out.println(grandFather2.toString());*/
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human (String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, int age, Human children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(children);
        }

        public Human (String name, boolean sex, int age, Human ... children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;

            for (Human o : children)
                this.children.add(o);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
