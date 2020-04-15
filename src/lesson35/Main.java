package lesson35;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Race.setBarrier(new CyclicBarrier(CARS_COUNT));
        Race.setSemaphore(new Semaphore(CARS_COUNT / 2));
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        ArrayList<Thread> racers = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            racers.add(new Thread(cars[i]));
            racers.get(racers.size() - 1).start();
        }

        for (Thread t : racers) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
