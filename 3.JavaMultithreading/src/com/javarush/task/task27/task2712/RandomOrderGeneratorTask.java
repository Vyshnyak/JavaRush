package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int creatingInterval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.creatingInterval = interval;
        this.tablets = tablets;
    }

    @Override
    public void run() {
        int index = (int) (Math.random() * (tablets.size() - 1));
        Tablet randomTablet = tablets.get(index);
        while (true) {
            randomTablet.createTestOrder();
            try {
                Thread.sleep(creatingInterval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
