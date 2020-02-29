package lesson02;

public class MyArraySizeException extends Exception {
    int x;
    int y = -1; // Может быть не инициализировано в конструкторе

    MyArraySizeException(int _x) {
        x = _x;
    }

    MyArraySizeException(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    public String toString() {
        String res;
        if (y < 0) {
            res = "Некорректный размер первого измерения массива: " + x;
        } else {
            res = "Некорректное количество элементов в строке " + x + ". Требовалось 4, получено " + y;
        }
        return res;
    }
}
