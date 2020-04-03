package lesson21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1 задание
        System.out.println("Задание 1:");
        ArrayList<Integer> list11 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list12 = swap(list11, 2,4);
        System.out.println(list12);
        System.out.println("");

        // 2 задание
        System.out.println("Задание 2:");
        String[] arr = {"alpha", "beta", "gamma", "delta"};
        ArrayList<String> list21 = arrayToList(arr);
        System.out.println(list21);
        System.out.println("");

        // 3 задание
        System.out.println("Задание 3:");
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 5; i++) {
            appleBox1.put(new Apple());
        }
        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());
        Box<Orange> orangeBox1 = new Box<>();
        for (int i = 0; i < 5; i++) {
            orangeBox1.put(new Orange());
        }
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.print("Веса этих коробок равны? ");
        appleBox1.compareTo(orangeBox1);
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 5; i++) {
            appleBox2.put(new Apple());
        }
        System.out.println("Вес второй коробки с яблоками: " + appleBox1.getWeight());
        System.out.print("Веса двух коробок с яблоками равны? ");
        appleBox1.compareTo(appleBox2);

        System.out.println("Пересыпем яблоки из первой коробки во вторую...");
        appleBox1.relocate(appleBox2);
        System.out.println("Готово");
        System.out.println("Теперь первая коробка весит " + appleBox1.getWeight() + ", а вторая - " + appleBox2.getWeight());
    }

    private static <T> ArrayList<T> swap(ArrayList<T> in, int a, int b) {
        ArrayList<T> out = new ArrayList<>();

        out.addAll(in);

        out.set(b, in.get(a));
        out.set(a, in.get(b));

        return out;
    }

    private static <T> ArrayList<T> arrayToList(T[] in) {
        ArrayList<T> out = new ArrayList<>();

        for (int i = 0; i < in.length; i++) {
            out.add(in[i]);
        }

        return out;
    }


}
