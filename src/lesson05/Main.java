package lesson05;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        singleThread();

        doubleThread();
    }

    private static void singleThread() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("В один поток: " + (System.currentTimeMillis() - startTime) + " мс");
    }

    private static void doubleThread() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();

        Thread t1 = new ArrayLoop(0);
        Thread t2 = new ArrayLoop(h);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("В два потока: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
