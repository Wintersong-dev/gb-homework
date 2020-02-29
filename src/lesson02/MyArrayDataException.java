package lesson02;

public class MyArrayDataException extends Exception {
    private int x;
    private int y;
    private String val;
    MyArrayDataException(int _x, int _y, String _val) {
        x = _x;
        y = _y;
        val = _val;
    }

    @Override
    public String toString() {
        return "Ошибка в данных массива. Координаты некорректного элемента: [" + x + ", " + y + "], значение элемента: \"" + val + "\"";
    }
}
