package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return (first == null ? n.first == null : n.first.equals(first)) && (last == null ? n.last == null : n.last.equals(last));
    }

    @Override
    public int hashCode() {
        int result = 1;

        result *= 31 + (first == null ? 0 : first.hashCode());
        result *= 31 + (last == null ? 0 : last.hashCode());

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
