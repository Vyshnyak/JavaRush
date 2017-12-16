package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "k", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            wordsList.add(new Word(words[i]));
            detectStartOfWord(crossword, words[i], wordsList.get(i));
        }

        return wordsList;
    }

    public static void detectStartOfWord(int[][] crossword, String word, Word wordCoords) {
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == word.charAt(0))
                    detectWord(crossword, word, wordCoords, j, i);
            }
        }
    }

    public static void detectWord(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        boolean isWordFound = false;

        if (!isWordFound) isWordFound = searchHorizontallyLeft(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchHorizontallyRight(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchVerticallyUp(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchVerticallyDown(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchDiagonallyUpRight(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchDiagonallyUpLeft(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchDiagonallyDownRight(crossword, word, wordCoords, startX, startY);
        if (!isWordFound) isWordFound = searchDiagonallyDownLeft(crossword, word, wordCoords, startX, startY);
    }

    public static boolean searchHorizontallyLeft(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endX = 0;

        for (int i = startX; i >= 0; i--) {
            if (concurrences != word.length() && crossword[startY][i] == word.charAt(concurrences))
                concurrences++;
            else
                break;
            endX = i;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, startY);
        }
        return concurrences == word.length();
    }

    public static boolean searchHorizontallyRight(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endX = 0;

        for (int i = startX; i < crossword[startY].length; i++) {
            if (concurrences != word.length() && crossword[startY][i] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endX = i;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, startY);
        }

        return concurrences == word.length();
    }

    public static boolean searchVerticallyUp(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endY = 0;

        for (int i = startY; i >= 0; i--) {
            if (concurrences != word.length() && crossword[i][startX] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(startX, endY);
        }

        return concurrences == word.length();
    }

    public static boolean searchVerticallyDown(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endY = 0;

        for (int i = startY; i < crossword.length; i++) {
            if (concurrences != word.length() && crossword[i][startX] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(startX, endY);
        }

        return concurrences == word.length();
    }

    public static boolean searchDiagonallyUpRight(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endY = 0;
        int endX = 0;

        for (int i = startY, j = startX; i >= 0 && j < crossword[startY].length; i--, j++) {
            if (concurrences != word.length() && crossword[i][j] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
            endX = j;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, endY);
        }

        return concurrences == word.length();
    }

    public static boolean searchDiagonallyUpLeft(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endY = 0;
        int endX = 0;

        for (int i = startY, j = startX; i >= 0 && j >= 0; i--, j--) {
            if (concurrences != word.length() && crossword[i][j] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
            endX = j;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, endY);
        }

        return concurrences == word.length();
    }

    public static boolean searchDiagonallyDownRight(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;

        int endY = 0;
        int endX = 0;

        for (int i = startY, j = startX; i < crossword.length && j < crossword[startY].length; i++, j++) {
            if (concurrences != word.length() && crossword[i][j] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
            endX = j;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, endY);
        }

        return concurrences == word.length();
    }

    public static boolean searchDiagonallyDownLeft(int[][] crossword, String word, Word wordCoords, int startX, int startY) {
        int concurrences = 0;
        int endY = 0;
        int endX = 0;

        for (int i = startY, j = startX; i < crossword.length && j >= 0; i++, j--) {
            if (concurrences != word.length() && crossword[i][j] == word.charAt(concurrences))
                concurrences++;
            else
                break;

            endY = i;
            endX = j;
        }

        if (concurrences == word.length()) {
            wordCoords.setStartPoint(startX, startY);
            wordCoords.setEndPoint(endX, endY);
        }

        return concurrences == word.length();
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
