package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        boolean isRectangle;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                isRectangle = a[i][j] == 1;

                if (isRectangle && (i + 1 == a.length || a[i + 1][j] == 0) &&
                                   (j + 1 == a[i].length || a[i][j + 1] == 0))
                {
                    count++;
                }
            }
        }
        return count;
    }

    /*public static int getRectangleCount(byte[][] a) {
        byte[][] aCopy = a;
        int count = 0;
        boolean isRectangle;

        for (int i = 0; i < aCopy.length; i++) {
            for (int j = 0; j < aCopy[i].length; j++) {
                isRectangle = a[i][j] == 1;

                if (isRectangle) {
                    findRectangle(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findRectangle(byte[][] a, int column, int row) {
        int recLen_i = 0;
        int recLen_j = 0;

        for (int i = row ; i < a[column].length; i++) {
            if (a[column][i] == 0)
                break;
            recLen_i++;
        }

        for (int i = column; i < a.length; i++) {
            if (a[i][row] == 0)
                break;
            recLen_j++;
        }

        clear(a, column, row, recLen_i, recLen_j);
    }

    public static void clear(byte[][] a, int column, int row, int columnLen, int rowLen) {
        for (int i = column; i < column + columnLen; i++) {
            for (int j = row; j < row + rowLen; j++) {
                if (a[i][j] == 0)
                    break;
                a[i][j] = 0;
            }
        }
    }*/
}
