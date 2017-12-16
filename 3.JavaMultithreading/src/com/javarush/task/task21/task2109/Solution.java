package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (!(obj instanceof A))
                return false;

            A a = (A) obj;

            return getI() == a.getI() && getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            int result = 1;

            result = 31 * result + getI();
            result = 31 * result + getJ();

            return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (!(obj instanceof B))
                return false;

            B b = (B) obj;

            return getName() != null ? getName().equals(b.getName()) : b.getName() != null;
        }

        @Override
        public int hashCode() {
            int result = 1;

            result = 31 * result + (getName() == null ? 0 : getName().hashCode());

            return result;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public static void main(String[] args) {

    }
}
