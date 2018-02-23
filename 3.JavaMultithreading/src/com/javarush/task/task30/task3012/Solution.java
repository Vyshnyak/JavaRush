package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        String ternaryNumber = convertFromDecimalToTernary(number);
        System.out.println(convertToSummands(new StringBuilder(ternaryNumber).reverse(), number));
    }

    public String convertFromDecimalToTernary(int number) {
        int reminder = number % 3;
        int dividedNumber = reminder == 2 ? number / 3 + 1 : number / 3;
        String convertedNumber = reminder == 2 ? "$" : String.valueOf(reminder);
        if (number >= 2) {
            return convertFromDecimalToTernary(dividedNumber) + convertedNumber;
        }
        return convertedNumber;
    }

    public String convertToSummands(StringBuilder ternaryNumber, int number) {
        StringBuilder summands = new StringBuilder(number + " =");
        for (int i = 0; i < ternaryNumber.length(); i++) {
            char num = ternaryNumber.charAt(i);
            switch (num) {
                case '$':
                    summands.append(" - ").append((int) Math.pow(3, i));
                    break;
                case '1':
                    summands.append(" + ").append((num - 48) * (int) Math.pow(3, i));
                    break;
            }
        }
        return summands.toString();
    }
}