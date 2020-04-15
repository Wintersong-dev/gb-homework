package lesson35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Race {
    private ArrayList<Stage> stages;
    static CyclicBarrier cb;
    static boolean isStarted = false;
    static Semaphore sm;
    static String winner = "";
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public static void setBarrier(CyclicBarrier barrier) {
        cb = barrier;
    }

    public static void setSemaphore(Semaphore semaphore) {
        sm = semaphore;
    }

    public static void raceStart() {
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // Сообщение должно высветиться только 1 раз
        if (!isStarted) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            isStarted = true;
        }

    }

    public static void startTunnel() {
        try {
            sm.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void endTunnel() {
        sm.release();
    }

    public synchronized static void setWinner(String car) {
        if (winner.length() == 0) {
            winner = car;
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победил " + car);
        }
    }
}
