package lesson34;

public class Main {
    static char sign = 'A';
    static final int num = 5;
    public static void main(String[] args) {
        Object mon = new Object();
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (sign != 'A') {
                            mon.wait();
                        }
                        System.out.print(sign);
                        sign = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException ignore) {}

        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (sign != 'B') {
                            mon.wait();
                        }

                        System.out.print(sign);
                        sign = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException ignore) {}

        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (sign != 'C') {
                            mon.wait();
                        }
                        System.out.print(sign);
                        sign = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException ignore) {}

        }).start();
    }
}
