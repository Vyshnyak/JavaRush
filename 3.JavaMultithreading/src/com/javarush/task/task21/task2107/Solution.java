package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (!(obj instanceof User))
                return false;

            User user = (User) obj;

            return age == user.age && (name != null ? name.equals(user.name) : user.name != null);
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name == null ? 0 : name.hashCode());
            return result;
        }
    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();

        /*LinkedHashMap<String, User> map = (LinkedHashMap<String, User>) users;
        solution.users = (Map<String, User>) map.clone();*/
        solution.users = new LinkedHashMap<>();

        for (Map.Entry<String, User> pair : users.entrySet())
            solution.users.put(pair.getKey(), (pair.getValue() == null ? null : pair.getValue().clone()));

        return solution;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Solution))
            return false;

        Solution solution = (Solution) obj;

        return users != null ? users.equals(solution.users) : solution.users != null;
    }

    @Override
    public int hashCode() {
        int result = 1;

        for (Map.Entry<String, User> pair : users.entrySet()) {
            result = 31 * result + (pair.getKey() == null ? 0 : pair.getKey().hashCode());
            result = 31 * result + (pair.getValue() == null ? 0 : pair.getValue().hashCode());
        }

        return result;
    }
}
