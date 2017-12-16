package com.javarush.task.task14.task1417;

/**
 * Created by Максим on 11.06.2017.
 */
public class USD extends Money {
    @Override
    public String getCurrencyName() {
        return "USD";
    }

    public USD(double amount) {
        super(amount);
    }
}
