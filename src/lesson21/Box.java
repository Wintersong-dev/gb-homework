package lesson21;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> content = new ArrayList<>();

    public void put(T elem) {
        content.add(elem);
    }

    public void withdraw(int index) {
        content.remove(index);
    }

    public double getWeight() {
        double d = 0.0;

        for(T elem : content) {
            d += elem.getWeight();
        }

        return d;
    }

    public void compareTo(Box<? extends Fruit> other) {
        if (Math.abs(this.getWeight() - other.getWeight()) < 0.0001) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void relocate(Box<T> dest) {
        int size = content.size();
        for (int i = 0; i < size; i++) {
            // После извлечения индексы всех элементов после i уменьшаются на 1, так что чтобы пересыпать ВСЕ, надо каждый раз брать нулевой элемент
            dest.put(content.get(0));
            withdraw(0);
        }
    }
}
