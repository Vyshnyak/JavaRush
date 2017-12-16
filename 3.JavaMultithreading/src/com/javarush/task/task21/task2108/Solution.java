package com.javarush.task.task21.task2108;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (!(obj instanceof Plant))
                return false;

            Plant plant = (Plant) obj;

            return name != null ? name.equals(plant.name) : plant.name != null;
        }

        @Override
        public int hashCode() {
            int result = 1;

            result = 31 * result + (name == null ? 0 : name.hashCode());

            return result;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        @Override
        public Tree clone() throws CloneNotSupportedException {
            Tree cloneTree = (Tree) super.clone();
            cloneTree.branches = branches.clone();

            return cloneTree;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (!(obj instanceof Tree))
                return false;

            Tree tree = (Tree) obj;

            return branches != null ? Arrays.equals(branches, tree.branches) : tree.branches != null;
        }

        @Override
        public int hashCode() {
            int result = 1;

            for (String branch : branches)
                result = 31 * result + (branch == null ? 0 : branch.hashCode());

            return result;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
