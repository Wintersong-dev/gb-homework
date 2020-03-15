package lesson03;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Задание 1
        String[] input = {"Медь", "Олово", "Свинец", "Золото", "Железо", "Серебро", "Золото", "Платина", "Железо", "Никель", "Хром", "Никель", "Цинк", "Титан", "Титан"};
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String elem : input) {
            wordMap.put(elem, wordMap.getOrDefault(elem, 0) + 1);
        }

        System.out.println(wordMap);
        System.out.println("");
        System.out.println("");

        // Задание 2
        PhoneBook book = new PhoneBook();
        book.add("Вася", "+7(000)000-00-00");
        book.add("Петя", "+7(000)000-00-01");
        book.add("Маша", "+7(000)000-00-02");
        book.add("Ваня", "+7(000)000-00-03");
        book.add("Миша", "+7(000)000-00-04");
        book.add("Даша", "+7(000)000-00-05");
        book.add("Саша", "+7(000)000-00-06");
        book.add("Олег", "+7(000)000-00-07");
        book.add("Женя", "+7(000)000-00-08");
        book.add("Ваня", "+7(000)000-00-09");
        System.out.println("");

        book.get("Ваня"); // 2 результата
        System.out.println("");
        book.get("Женя"); // 1 результат
        System.out.println("");
        book.get("Максим"); // 0 результатов
    }
}
