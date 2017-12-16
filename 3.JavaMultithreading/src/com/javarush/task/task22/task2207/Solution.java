package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String[] words = readWordsFromFile(fileName);

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String revString = new StringBuilder(words[j]).reverse().toString();
                if (words[i].equals(revString)) {
                    Pair pair = new Pair(words[j], words[i]);
                    if (!result.contains(pair))
                        result.add(pair);
                }
            }
        }

        printPairs();
    }

    public static String[] readWordsFromFile(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        while ((line = fileReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(" ");
        }

        fileReader.close();

        return stringBuilder.toString().split(" ");
    }

    public static void printPairs() {
        for (Pair pair : result) {
            System.out.printf("%s %s%n", pair.first, pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
