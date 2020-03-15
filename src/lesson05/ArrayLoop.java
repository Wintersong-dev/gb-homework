package lesson05;

public class ArrayLoop extends Thread {

    int pos;

    ArrayLoop(int _pos) {
        pos = _pos;
    }

    @Override
    public void run() {
        float[] arrayPart = new float[Main.h];

        for (int i = pos; i < pos + Main.h; i++) {
            arrayPart[i - pos] = (float)(Main.arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(arrayPart, 0, Main.arr, pos, Main.h);

    }
}
