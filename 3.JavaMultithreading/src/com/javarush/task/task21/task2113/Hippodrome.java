package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());

        game.getHorses().add(new Horse("Max", 3, 0));
        game.getHorses().add(new Horse("Igor", 3, 0));
        game.getHorses().add(new Horse("Alex", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : getHorses()) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        int indOfHorse = 0;
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > horses.get(indOfHorse).getDistance())
                indOfHorse = i;
        }
        return horses.get(indOfHorse);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
